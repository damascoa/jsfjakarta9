package com.olivet.filters;

import jakarta.servlet.http.HttpSession;

public class Session {
    private String usuario;
    private String token;
    HttpSession hsession;
    public Session(String user,  HttpSession hsession) {
        this.usuario = user;
        this.token = hsession.getId();
        this.hsession = hsession;
   }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public HttpSession getHsession() {
        return hsession;
    }

    public void setHsession(HttpSession hsession) {
        this.hsession = hsession;
    }
}
