package com.example.moborg.adapter.in.web;

public record Participant(String fullName,
                          String gitHubUserName,
                          String email,
                          String discordUserName,
                          boolean newToMobbing) {
}
