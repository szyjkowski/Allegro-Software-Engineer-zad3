package pl.szyjkowski.githubapi;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class GitHubUserRepositoryControllerTest {

    @InjectMocks
    private GitHubUserRepositoryController cut;

    @Mock
    private GitHubUserRepositoryService serviceMock;

    @Mock
    private RestTemplate restTemplateMock;


    @Test
    @DisplayName("should return put param message if the path in list-repo has no parameter")
    public void test1() {
        //given
        String name = "";
        //when
        String actualOutput = cut.listUserRepositories(name);
        //then
        String expectedOutput = "U have to put param name. Example: http://localhost:8080/github-api/list-repo?name=GitHubUserName";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return put param message if the path in count-stars has no parameter")
    public void test2() {
        //given
        String name = "";
        //when
        String actualOutput = cut.countUserStars(name);
        //then
        String expectedOutput = "U have to put param name. Example: http://localhost:8080/github-api/count-stars?name=GitHubUserName";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return Error 404 status for count-stars if param is not empty and restTemplate throw Http status 404")
    public void test3() {
        //given
        String name = "szyjkowski";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        HttpClientErrorException httpClientErrorException = new HttpClientErrorException(httpStatus, "status not found");

        String URL = "https://api.github.com/users/" + name + "/repos";;
        BDDMockito.given(restTemplateMock.getForEntity(
                URL, GitHubUserRepository[].class)).willThrow(httpClientErrorException);
        //when
        String actualOutput = cut.countUserStars(name);
        //then
        String expectedOutput = "Error 404 status not found. User not exist.";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return Error 404 status for list-repo if param is not empty and restTemplate throw Http status 404")
    public void test4() {
        //given
        String name = "szyjkowski";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        HttpClientErrorException httpClientErrorException = new HttpClientErrorException(httpStatus, "status not found");

        String URL = "https://api.github.com/users/" + name + "/repos";;
        BDDMockito.given(restTemplateMock.getForEntity(
                URL, GitHubUserRepository[].class)).willThrow(httpClientErrorException);
        //when
        String actualOutput = cut.listUserRepositories(name);
        //then
        String expectedOutput = "Error 404 status not found. User not exist.";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return Error code and status for count-stars if param is not empty and restTemplate throw Http error exception")
    public void test5() {
        //given
        String name = "szyjkowski";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        HttpClientErrorException httpClientErrorException = new HttpClientErrorException(httpStatus, "status not found");
        String URL = "https://api.github.com/users/" + name + "/repos";;
        BDDMockito.given(restTemplateMock.getForEntity(
                URL, GitHubUserRepository[].class)).willThrow(httpClientErrorException);
        //when
        String actualOutput = cut.countUserStars(name);
        //then
        String expectedOutput = "Error 404 status not found. User not exist.";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return Error code and status for list-repo if param is not empty and restTemplate throw Http error exception")
    public void test6() {
        //given
        String name = "szyjkowski";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        HttpClientErrorException httpClientErrorException = new HttpClientErrorException(httpStatus, "status not found");

        String URL = "https://api.github.com/users/" + name + "/repos";;
        BDDMockito.given(restTemplateMock.getForEntity(
                URL, GitHubUserRepository[].class)).willThrow(httpClientErrorException);
        //when

        String actualOutput = cut.listUserRepositories(name);
        //then
        String expectedOutput = "Error 404 status not found. User not exist.";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should return count of stars from all user repositories if name is not empty and restTemplate return statusCode 200")
    public void test7() {
        //given
        String name = "szyjkowski";
        String URL = "https://api.github.com/users/" + name + "/repos";;
        GitHubUserRepository[] gitHubUserRepositories = GitHubUserRepositoryArrayTestFactory.create();
        ResponseEntity<GitHubUserRepository[]> responseEntity = ResponseEntity.ok(gitHubUserRepositories);
        BDDMockito.given(restTemplateMock.getForEntity(
                URL, GitHubUserRepository[].class)).willReturn(responseEntity);
        String willReturnStringValue = "Count of stars form all user repositories = 20.";
        BDDMockito.given(serviceMock.getCountOfUserStars(gitHubUserRepositories)).willReturn(willReturnStringValue);
        //when

        String actualOutput = cut.countUserStars(name);
        //then
        String expectedOutput = "Count of stars form all user repositories = 20.";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("should list user repositories with names and count of stars for each on if name is not empty and restTemplate return statusCode 200")
    public void test8() {
        //given
        String name = "szyjkowski";
        String URL = "https://api.github.com/users/" + name + "/repos";;
        GitHubUserRepository[] gitHubUserRepositories = GitHubUserRepositoryArrayTestFactory.create();
        ResponseEntity<GitHubUserRepository[]> responseEntity = ResponseEntity.ok(gitHubUserRepositories);
        BDDMockito.given(restTemplateMock.getForEntity(
                URL, GitHubUserRepository[].class)).willReturn(responseEntity);
        String willReturnStringValue =  " Repository name: repositoryName1 has 10 stars. <br/>"
                +  " Repository name: " + "repositoryName1" +
                " has 10 stars. <br/>";
        BDDMockito.given(serviceMock.getListRepository(gitHubUserRepositories)).willReturn(willReturnStringValue);
        //when
        String actualOutput = cut.listUserRepositories(name);
        //then
        String expectedOutput = " Repository name: repositoryName1 has 10 stars. <br/>"
                +  " Repository name: " + "repositoryName1" +
                " has 10 stars. <br/>";
        assertEquals(expectedOutput, actualOutput);
    }
}
