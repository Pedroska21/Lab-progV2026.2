package com.pedroska.games.service;

import com.pedroska.games.dto.request.LoginRequestDto;
import com.pedroska.games.dto.request.RegisterRequestDto;

public interface AuthService {
    public String login(LoginRequestDto request);
    public String register(RegisterRequestDto request);
}
