package pl.szyjkowski.githubapi;

import static org.junit.jupiter.api.Assertions.*;

class GitHubUserTestFactory {
    public static GitHubUser create() {
        return new GitHubUser("szyjkowski");
    }

}