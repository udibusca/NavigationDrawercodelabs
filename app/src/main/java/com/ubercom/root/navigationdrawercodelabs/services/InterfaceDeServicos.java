package com.ubercom.root.navigationdrawercodelabs.services;


import com.ubercom.root.navigationdrawercodelabs.model.Aluno;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface InterfaceDeServicos {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("/lista_de_alunos")
    Call<List<Aluno>> webserviceNotasDeAlunos();

}

