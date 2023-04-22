package eus.ehu.sprint1.businessLogic;

import eus.ehu.sprint1.Domain.User;

public interface BlFacade {
    String getID(String username);
    void login(String username);
    void register(String username,String TOKEN);
    String getusername(String username);
}
