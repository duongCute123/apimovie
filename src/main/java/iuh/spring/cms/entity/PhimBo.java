package iuh.spring.cms.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Builder
public class PhimBo {
    private String id;
    private String title;
    private String short_description;
    private String images;
    private String avg_rate;
    private String episode;
    private String slug;
    private String link_play;
    private String related_season;
    private String tags_genre_txt;
    private String people_str;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAvg_rate() {
        return avg_rate;
    }

    public void setAvg_rate(String avg_rate) {
        this.avg_rate = avg_rate;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLink_play() {
        return link_play;
    }

    public void setLink_play(String link_play) {
        this.link_play = link_play;
    }

    public String getRelated_season() {
        return related_season;
    }

    public void setRelated_season(String related_season) {
        this.related_season = related_season;
    }

    public String getTags_genre_txt() {
        return tags_genre_txt;
    }

    public void setTags_genre_txt(String tags_genre_txt) {
        this.tags_genre_txt = tags_genre_txt;
    }

    public String getPeople_str() {
        return people_str;
    }

    public void setPeople_str(String people_str) {
        this.people_str = people_str;
    }

    public PhimBo(String id, String title, String short_description, String images, String avg_rate, String episode,
            String slug, String link_play, String related_season, String tags_genre_txt, String people_str) {
        this.id = id;
        this.title = title;
        this.short_description = short_description;
        this.images = images;
        this.avg_rate = avg_rate;
        this.episode = episode;
        this.slug = slug;
        this.link_play = link_play;
        this.related_season = related_season;
        this.tags_genre_txt = tags_genre_txt;
        this.people_str = people_str;
    }


}
