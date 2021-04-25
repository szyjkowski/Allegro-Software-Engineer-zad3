package pl.szyjkowski.githubapi.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.szyjkowski.githubapi.factory.GitHubUserRepositoryArrayTestFactory;
import pl.szyjkowski.githubapi.model.GitHubUserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class GitHubUserRepositoryServiceTest {

    @InjectMocks
    private GitHubUserRepositoryService cut;

    @Test
    @DisplayName("should return count of stars form all users repository when GitHubUserRepository[] is not empty")
    public void test1() {
        //given
        GitHubUserRepository[] githubUserRepositories = GitHubUserRepositoryArrayTestFactory.create();
        //when
        String actualOutput = cut.getCountOfUserStars(githubUserRepositories);
        //then
        String expectedOutput = "Count of stars form all user repositories = 20.";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return USER_HAS_NO_REPOSITORY value for count of stars when GitHubUserRepository[] is empty")
    public void test2() {
        //given
        GitHubUserRepository[] githubUserRepositories = GitHubUserRepositoryArrayTestFactory.createEmpty();
        //when
        String actualOutput = cut.getCountOfUserStars(githubUserRepositories);
        //then
        String expectedOutput = "User has no repositories";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return list of user repositories with names and count of stars for each on")
    public void test3() {
        //given
        GitHubUserRepository[] githubUserRepositories = GitHubUserRepositoryArrayTestFactory.create();
        //when
        String actualOutput = cut.getListRepository(githubUserRepositories);
        //then
        String expectedOutput = " Repository name: repositoryName1 has 10 stars. <br/>"
                + " Repository name: " + "repositoryName1" +
                " has 10 stars. <br/>";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return USER_HAS_NO_REPOSITORY value for count of stars when GitHubUserRepository[] is empty")
    public void test4() {
        //given
        GitHubUserRepository[] githubUserRepositories = GitHubUserRepositoryArrayTestFactory.createEmpty();
        //when
        String actualOutput = cut.getListRepository(githubUserRepositories);
        //then
        String expectedOutput = "User has no repositories";
        assertEquals(expectedOutput, actualOutput);

    }
}