package com.projetopoo.mytickets.model.DTOs;

public record RegisterRequest(String nome, String email, String password, Boolean isAdmin, String username) {
}
