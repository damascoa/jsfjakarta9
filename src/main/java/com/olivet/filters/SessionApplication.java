package com.olivet.filters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SessionApplication {

    private List<Session> sessions = new ArrayList<>();


    public void addSession(String user, HttpSession hsession){
        sessions.add(new Session(user,  hsession));
    }

    public Boolean userHasLogged(String user,HttpSession session){
        return sessions.stream().anyMatch(p -> p.getUsuario().equalsIgnoreCase(user) && !session.getId().equals(p.getHsession().getId()));
    }
}
