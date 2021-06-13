package com.wchan.bookstore.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "BookDto", description = "All details about a book")
public class BookDto {

    @ApiModelProperty(
            readOnly = true,
            value = "UUID",
            dataType = "UUID",
            example = "b5607d38-8fc1-43ef-b44e-34967083c80b",
            notes = "data transfer object"
    )
    private UUID id;

    @ApiModelProperty(
            value = "title",
            dataType = "String",
            example = "book title",
            notes = "book title",
            required = true
    )
    private String title;

    @ApiModelProperty(
            value = "description",
            dataType = "String",
            example = "book description",
            notes = "book description",
            required = true
    )
    private String description;

    @ApiModelProperty(
            value = "releaseYEar",
            dataType = "int",
            example = "2020",
            notes = "book releaseYear",
            required = true
    )
    private int releaseYear;
}
