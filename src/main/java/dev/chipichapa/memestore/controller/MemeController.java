package dev.chipichapa.memestore.controller;

import dev.chipichapa.memestore.domain.dto.BasicApiResponse;
import dev.chipichapa.memestore.dto.meme.CreateMemeRequest;
import dev.chipichapa.memestore.dto.meme.CreateMemeResponse;
import dev.chipichapa.memestore.dto.meme.GetMemeRequest;
import dev.chipichapa.memestore.dto.meme.GetMemeResponse;
import dev.chipichapa.memestore.usecase.ifc.MemeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/meme")
@RequiredArgsConstructor
public class MemeController {

    private final MemeUseCase memeUseCase;

    @PostMapping("/create")
    ResponseEntity<BasicApiResponse<?>> create(@RequestParam("asset") String assetTicket,
                                               @RequestParam("gallery_id") Integer galleryId,
                                               @RequestBody CreateMemeRequest createMemeRequest) {

        CreateMemeResponse response = memeUseCase.create(
                new CreateMemeRequest(createMemeRequest, galleryId, assetTicket)
        );

        return new ResponseEntity<>(new BasicApiResponse<>(false, response), HttpStatus.OK);
    }

    @GetMapping("{gallery_id}_{id}")
    ResponseEntity<BasicApiResponse<?>> get(@PathVariable("gallery_id") int galleryId,
                                            @PathVariable("id") int memeId) {
        GetMemeResponse response = memeUseCase.get(new GetMemeRequest(galleryId, memeId));

        return new ResponseEntity<>(new BasicApiResponse<>(false, response), HttpStatus.OK);
    }
}
