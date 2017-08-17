package api.beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "body",
    "post comment"
})
public class Comment {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("body")
    private Body body;
    @JsonProperty("post comment")
    private String postComment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Comment() {
    }

    /**
     * 
     * @param postComment
     * @param id
     * @param body
     */
    public Comment(Integer id, Body body, String postComment) {
        super();
        this.id = id;
        this.body = body;
        this.postComment = postComment;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("body")
    public Body getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(Body body) {
        this.body = body;
    }

    @JsonProperty("post comment")
    public String getPostComment() {
        return postComment;
    }

    @JsonProperty("post comment")
    public void setPostComment(String postComment) {
        this.postComment = postComment;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(body).append(postComment).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Comment) == false) {
            return false;
        }
        Comment rhs = ((Comment) other);
        return new EqualsBuilder().append(id, rhs.id).append(body, rhs.body).append(postComment, rhs.postComment).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
