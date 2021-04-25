package pl.szyjkowski.githubapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUserRepository {
    private String name;

    @JsonProperty("owner")
    private GitHubUser gitHubUser;

    @JsonProperty("stargazers_count")
    private int countOfStars;

    public GitHubUserRepository(String name, GitHubUser gitHubUser, int countOfStars) {
        this.name = name;
        this.gitHubUser = gitHubUser;
        this.countOfStars = countOfStars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGitHubUser(GitHubUser gitHubUser) {
        this.gitHubUser = gitHubUser;
    }

    public void setCountOfStars(int countOfStars) {
        this.countOfStars = countOfStars;
    }

    public String getName() {
        return name;
    }

    public GitHubUser getGitHubUser() {
        return gitHubUser;
    }

    public int getCountOfStars() {
        return countOfStars;
    }


}
