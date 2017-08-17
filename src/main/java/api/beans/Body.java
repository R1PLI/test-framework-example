package api.beans;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "some comment"
})
public class Body {

    @JsonProperty("some comment")
    private String someComment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Body() {
    }

    /**
     * 
     * @param someComment
     */
    public Body(String someComment) {
        super();
        this.someComment = someComment;
    }

    @JsonProperty("some comment")
    public String getSomeComment() {
        return someComment;
    }

    @JsonProperty("some comment")
    public void setSomeComment(String someComment) {
        this.someComment = someComment;
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
        return new HashCodeBuilder().append(someComment).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Body) == false) {
            return false;
        }
        Body rhs = ((Body) other);
        return new EqualsBuilder().append(someComment, rhs.someComment).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
