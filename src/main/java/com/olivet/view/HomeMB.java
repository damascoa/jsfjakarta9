package com.olivet.view;

import com.olivet.controller.ClienteEJB;
import com.olivet.filters.SessionApplication;
import com.olivet.model.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class HomeMB {
    @EJB
    ClienteEJB ejb;
    @Inject
    SessionApplication sessionApplication;

    private List<Cliente> clientes = new ArrayList<>();

    private String nome;
    private Integer idade;


    private String login, senha;

    public HomeMB() {
    }


    @PostConstruct
    public void init() {
        System.out.println("MANAGED BEAN");
        clientes = ejb.clientes();


    }

    public void login() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(true);



        if(sessionApplication.userHasLogged(login, session)){
            //Desloga o primeiro login

        }

        sessionApplication.addSession(login, session);



        session.setAttribute("loggedUser", login);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("./Restrito/index.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(){

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
