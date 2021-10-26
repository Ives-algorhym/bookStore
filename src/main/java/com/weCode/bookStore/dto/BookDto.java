package com.weCode.bookStore.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "BookDto", description = "All details about book")
public class BookDto {

    @ApiModelProperty(
            readOnly = true,
            value = "UUID",
            dataType = "UUID",
            example = "e518a570-ea16-446b-afab-c654c41448b2",
            notes = "the database generated uuid for id",
            required = true
    )
    private UUID id;


    @ApiModelProperty(
            readOnly = true,
            value = "title",
            dataType = "String",
            example = "Book title",
            notes = "title of the book",
            required = true
    )
    private String title;

    @ApiModelProperty(
            readOnly = true,
            value = "description",
            dataType = "String",
            example = "book of programming",
            notes = "shor description about the book",
            required = true
    )
    private String description;

    @ApiModelProperty(
            readOnly = true,
            value = "releaseYear",
            dataType = "int",
            example = "2020",
            notes = "year of realease",
            required = true
    )
    private int releaseYear;


}
