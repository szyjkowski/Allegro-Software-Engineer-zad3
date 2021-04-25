package pl.szyjkowski.githubapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.szyjkowski.githubapi.Constants;
import pl.szyjkowski.githubapi.model.GitHubUserRepository;
import pl.szyjkowski.githubapi.service.GitHubUserRepositoryService;

@RestController
@RequestMapping("/github-api")
public class GitHubUserRepositoryController implements Constants {
    private final RestTemplate restTemplate;
    private final GitHubUserRepositoryService service;

    public GitHubUserRepositoryController(RestTemplate restTemplate, GitHubUserRepositoryService service) {
        this.restTemplate = restTemplate;
        this.service = service;
    }

    @GetMapping("list-repo")
    public String listUserRepositories(@RequestParam(defaultValue = "") String name) {
        if(!name.isEmpty()) {
            return getListUserRepositoriesOrReturnHttpError(name);
        } else {
            return MESSAGE_IF_NO_PARAM_PREFIX + "list-repo" + MESSAGE_IF_NO_PARAM_SUFFIX;
        }
    }

    private String getListUserRepositoriesOrReturnHttpError(String name) {
        try {
            ResponseEntity<GitHubUserRepository[]> githubUserRepository = restTemplate.getForEntity(
                    API_URL_PREFIX + name + API_URL_SUFFIX, GitHubUserRepository[].class);
            return service.getListRepository(githubUserRepository.getBody());

        } catch (HttpClientErrorException e) {
            return displayErrorAndStatusCode(e);
        }
    }

    @GetMapping("count-stars")
    public String countUserStars(@RequestParam(defaultValue = "") String name) {
        if (!name.isEmpty()) {
            return getCountOfStarsOrReturnHttpError(name);
        } else {
            return MESSAGE_IF_NO_PARAM_PREFIX + "count-stars" + MESSAGE_IF_NO_PARAM_SUFFIX;
        }
    }

    private String getCountOfStarsOrReturnHttpError(String name) {
        try {
            ResponseEntity<GitHubUserRepository[]> githubUserRepository = restTemplate.getForEntity(
                    API_URL_PREFIX + name + API_URL_SUFFIX, GitHubUserRepository[].class);
            return service.getCountOfUserStars(githubUserRepository.getBody());
        }
        catch (HttpClientErrorException e) {
            return displayErrorAndStatusCode(e);
        }
    }

    private String displayErrorAndStatusCode(HttpClientErrorException e) {
        if (e.getStatusCode().value() == 404) {
            return "Error " + e.getStatusCode().value() + " " + e.getStatusText() + ". User not exist.";
        } else {
            return "Error " + e.getStatusCode().value() + " " + e.getStatusText();
        }
    }
}

