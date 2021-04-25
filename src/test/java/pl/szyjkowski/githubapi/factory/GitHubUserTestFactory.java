package pl.szyjkowski.githubapi.factory;

import pl.szyjkowski.githubapi.model.GitHubUser;

class GitHubUserTestFactory {
    public static GitHubUser create() {
        return new GitHubUser("szyjkowski");
    }
}