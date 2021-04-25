package pl.szyjkowski.githubapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser {
    private String login;

    public GitHubUser(String login) {
        this.login = login;
    }

    public GitHubUser() {
    }

    public String getLogin() {
        return login;
    }
}
