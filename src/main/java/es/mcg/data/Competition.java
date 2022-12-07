package es.mcg.data;

import java.time.LocalDateTime;

public class Competition {
    private Integer competition_id;
    private Integer season_id;
    private String country_name;
    private String competition_name;
    private String competition_gender;
    private Boolean competition_youth;
    private Boolean competition_international;
    private String season_name;
    private LocalDateTime match_updated;
    private LocalDateTime match_updated_360;
    private LocalDateTime match_available_360;
    private LocalDateTime match_available;

    public Competition()
    {
        this.competition_id = 0;
        this.season_id = 0;
        this.country_name = "";
        this.competition_name = "";
        this.competition_gender = "";
        this.competition_youth = false;
        this.competition_international = false;
        this.season_name = "";
    }

    public Integer getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(Integer competition_id) {
        this.competition_id = competition_id;
    }

    public Integer getSeason_id() {
        return season_id;
    }

    public void setSeason_id(Integer season_id) {
        this.season_id = season_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getCompetition_gender() {
        return competition_gender;
    }

    public void setCompetition_gender(String competition_gender) {
        this.competition_gender = competition_gender;
    }

    public Boolean getCompetition_youth() {
        return competition_youth;
    }

    public void setCompetition_youth(Boolean competition_youth) {
        this.competition_youth = competition_youth;
    }

    public Boolean getCompetition_international() {
        return competition_international;
    }

    public void setCompetition_international(Boolean competition_international) {
        this.competition_international = competition_international;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public LocalDateTime getMatch_updated() {
        return match_updated;
    }

    public void setMatch_updated(LocalDateTime match_updated) {
        this.match_updated = match_updated;
    }

    public LocalDateTime getMatch_updated_360() {
        return match_updated_360;
    }

    public void setMatch_updated_360(LocalDateTime match_updated_360) {
        this.match_updated_360 = match_updated_360;
    }

    public LocalDateTime getMatch_available_360() {
        return match_available_360;
    }

    public void setMatch_available_360(LocalDateTime match_available_360) {
        this.match_available_360 = match_available_360;
    }

    public LocalDateTime getMatch_available() {
        return match_available;
    }

    public void setMatch_available(LocalDateTime match_available) {
        this.match_available = match_available;
    }
}
