package com.helpdesk.demo.service;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import com.helpdesk.demo.model.PersistentLogin;
import com.helpdesk.demo.repository.PersistentLoginRepository;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class MongoPersistentTokenService implements PersistentTokenRepository {

    
    private final PersistentLoginRepository repository;
   
    public MongoPersistentTokenService(PersistentLoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        PersistentLogin persistentLogin = new PersistentLogin(
                token.getSeries(),
                token.getUsername(),
                token.getTokenValue(),
                LocalDateTime.now()
        );
        repository.save(persistentLogin);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        repository.findById(series).ifPresent(persistentLogin -> {
            persistentLogin.setToken(tokenValue);
            persistentLogin.setLastUsed(LocalDateTime.now());
            repository.save(persistentLogin);
        });
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String series) {
        return repository.findById(series)
                .map(p->new PersistentRememberMeToken(
                    p.getUsername(), 
                    p.getSeries(), 
                    p.getToken(), 
                    new Date()  
                )).orElse(null);
    }

    @Override
    public void removeUserTokens(String username) {
        repository.deleteByUsername(username);
    }
}
