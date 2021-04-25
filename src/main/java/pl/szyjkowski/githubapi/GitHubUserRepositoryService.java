package pl.szyjkowski.githubapi;

import org.springframework.stereotype.Service;

@Service
public class GitHubUserRepositoryService implements Constants {

    public String getCountOfUserStars(GitHubUserRepository[] githubUserRepository) {
        int countOfStars = 0;
        for (GitHubUserRepository repository : githubUserRepository) {
            countOfStars += repository.getCountOfStars();
        }

        String countOfStarsString = "Count of stars form all user repositories = " +
                String.valueOf(countOfStars) + ".";
        return checkUserHasRepository(githubUserRepository, countOfStarsString);
    }

    public String getListRepository(GitHubUserRepository[] githubUserRepository) {
        String listOutput = "";
        for (GitHubUserRepository repository : githubUserRepository) {
            listOutput += " Repository name: " + repository.getName() +
                    " has " + repository.getCountOfStars() + " stars. <br/>";
        }

        return checkUserHasRepository(githubUserRepository, listOutput);
    }

    private static String checkUserHasRepository(GitHubUserRepository[] githubUserRepository, String output) {
        if (githubUserRepository.length != 0) {
            return output;
        } else {
            return USER_HAS_NO_REPOSITORY;
        }
    }
}

