package pl.szyjkowski.githubapi;

import org.springframework.http.ResponseEntity;

public class GitHubUserRepositoryArrayTestFactory {
    public static GitHubUserRepository[] create() {
        GitHubUserRepository[] gitHubUserRepositories = {GitHubUserRepositoryTestFactory.create(), GitHubUserRepositoryTestFactory.create()};
        return gitHubUserRepositories;
    }

    public static GitHubUserRepository[] createEmpty() {
        GitHubUserRepository[] gitHubUserRepositories = new GitHubUserRepository[0];
        return gitHubUserRepositories;
    }
}
