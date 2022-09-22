package mo.atef.amit.amit_dayseven.fcm;

import java.io.Serializable;

public class ConfigFcmNotification implements Serializable {
    public ConfigFcmNotification(Boolean content_available, String bodyText, String organization, String subtitle, String sound, String imageUrl, String organizationId, String body, String priority, String title) {
        this.content_available = content_available;
        this.bodyText = bodyText;
        this.organization = organization;
        this.subtitle = subtitle;
        this.sound = sound;
        this.imageUrl = imageUrl;
        this.OrganizationId = organizationId;
        this.body = body;
        this.priority = priority;
        this.title = title;
    }

    private Boolean content_available;

    private String bodyText;

    private String organization;

    private String subtitle;

    private String sound;

    private String imageUrl;

    private String OrganizationId;

    private String body;

    private String priority;

    private String title;

    public Boolean getContent_available() {
        return this.content_available;
    }

    public void setContent_available(Boolean content_available) {
        this.content_available = content_available;
    }

    public String getBodyText() {
        return this.bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getOrganization() {
        return this.organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSound() {
        return this.sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOrganizationId() {
        return this.OrganizationId;
    }

    public void setOrganizationId(String OrganizationId) {
        this.OrganizationId = OrganizationId;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
