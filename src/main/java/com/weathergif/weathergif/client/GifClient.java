package com.weathergif.weathergif.client;

import com.weathergif.weathergif.entity.GiphyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "gifClient", url = "https://api.giphy.com/v1/gifs")
public interface GifClient {

    @GetMapping("/random")
    GiphyResponse getRandomGif(
            @RequestParam String api_key,
            @RequestParam String tag,
            @RequestParam String rating
    );
}
