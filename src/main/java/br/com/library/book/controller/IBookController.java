package br.com.library.book.controller;

import br.com.library.book.dto.BookResponse;
import br.com.library.book.dto.LibraryBookResponse;
import br.com.library.common.exception.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface IBookController {


    ResponseEntity<Boolean> healthApi();

    @Operation(description = "Get all books in elastic search")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return response with book list",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LibraryBookResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected errors during query", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<LibraryBookResponse> getAll();


    @Operation(description = "Get One Book by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return response with book list",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LibraryBookResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found book", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected errors during query", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<BookResponse> getByID(String id);

    @Operation(description = "Get all books by gere")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return response with all book with genre",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LibraryBookResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected errors during query", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<LibraryBookResponse> getByGenre(String genre);


    @Operation(description = "Get all books by author name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return response with all book list with author name",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LibraryBookResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected errors during query", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<LibraryBookResponse> getByAuthor(String authorName);

}
