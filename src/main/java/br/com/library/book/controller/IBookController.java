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
    ResponseEntity<LibraryBookResponse> getAll() throws Exception;


    @Operation(description = "Get One Book by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return response with book list",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = BookResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found book", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected errors during query", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<BookResponse> getByID(String id) throws Exception ;

    @Operation(description = "Get all books by gere")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return response with all book with genre",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LibraryBookResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected errors during query", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<LibraryBookResponse> getByGenre(String genre) throws Exception;


    @Operation(description = "Get all books by author name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return response with all book list with author name",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LibraryBookResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected errors during query", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<LibraryBookResponse> getByAuthor(String authorName) throws Exception ;


    @Operation(description = "Get recents all books")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return response with all books searched in the last twelve hours",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected errors during query", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<String> recentSearches() throws Exception;

}
