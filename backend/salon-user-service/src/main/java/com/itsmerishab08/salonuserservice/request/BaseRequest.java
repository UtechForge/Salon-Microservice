package com.itsmerishab08.salonuserservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {
    @JsonProperty("page_size")
    int pageSize = 10;
    @JsonProperty("page_no")
    int pageNumber = 1;

}
