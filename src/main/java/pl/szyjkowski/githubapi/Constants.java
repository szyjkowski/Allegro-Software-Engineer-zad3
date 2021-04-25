package pl.szyjkowski.githubapi;

public interface Constants {
    String API_URL_PREFIX = "https://api.github.com/users/";
    String API_URL_SUFFIX = "/repos";
    String USER_HAS_NO_REPOSITORY = "User has no repositories";
    String MESSAGE_IF_NO_PARAM_PREFIX = "U have to put param name. Example: http://localhost:8080/github-api/";
    String MESSAGE_IF_NO_PARAM_SUFFIX = "?name=GitHubUserName";
}
