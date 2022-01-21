package com.ebff.challenge.spaceflightnews.controller.test;

import com.ebff.challenge.spaceflightnews.controller.ArticleController;
import com.ebff.challenge.spaceflightnews.model.Article;
import com.ebff.challenge.spaceflightnews.model.Event;
import com.ebff.challenge.spaceflightnews.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ArticleController.class)
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleRepository articleRepository;

    @Test
    public void findAllArticles() throws Exception{
        /*Article article =
                new Article(10,
                            true,
                            "SpaceX wins $102 million Air Force contract to demonstrate technologies for point-to-point space transportation",
                            "https://spacenews.com/spacex-wins-102-million-air-force-contract-to-demonstrate-technologies-for-point-to-point-space-transportation/",
                            "https://spacenews.com/wp-content/uploads/2021/10/Screen-Shot-2021-10-20-at-11.51.44-AM.png",
                            "SpaceNews",
                            "The U.S. Air Force awarded SpaceX a $102 million five-year contract to demonstrate technologies and capabilities to transport military cargo and humanitarian aid around the world on a heavy rocket.",
                            "2022-01-19T23:43:31.000Z",
                            "2022-01-19T23:43:31.896Z",
                            false,
                        List<Event>(){"2e650790-ff3e-434a-b028-a6a1a13cfc94", "Launch Library 90"});*/
    }
}
