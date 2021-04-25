package pl.szyjkowski.githubapi.factory;

import pl.szyjkowski.githubapi.model.GitHubUser;
import pl.szyjkowski.githubapi.model.GitHubUserRepository;

class GitHubUserRepositoryTestFactory {

    public static GitHubUserRepository create() {
        GitHubUser gitHubUser = GitHubUserTestFactory.create();
        return new GitHubUserRepository("repositoryName1", gitHubUser, 10);
    }
}