package pl.szyjkowski.githubapi;

class GitHubUserRepositoryTestFactory {

    public static GitHubUserRepository create() {
        GitHubUser gitHubUser = GitHubUserTestFactory.create();
        return new GitHubUserRepository("repositoryName1", gitHubUser, 10);
    }

}