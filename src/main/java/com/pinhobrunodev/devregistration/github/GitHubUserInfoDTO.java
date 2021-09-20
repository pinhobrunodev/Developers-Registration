package com.pinhobrunodev.devregistration.github;

public class GitHubUserInfoDTO {

    private String name;
    private String bio;
    private String blog;
    private String company;

    public  GitHubUserInfoDTO(){

    }

    public GitHubUserInfoDTO(String name, String bio, String blog, String company) {
        this.name = name;
        this.bio = bio;
        this.blog = blog;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
