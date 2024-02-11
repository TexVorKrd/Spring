package ru.veb.web.servises;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.veb.web.clients.OfferAPI;
import ru.veb.web.clients.UserAPI;

@Service
@RequiredArgsConstructor
public class WebServices {
    private final UserAPI userAPI;
    private final OfferAPI offerAPI;


    /**
     * Тащим сообщение из микросервиса сделок
     *
     * @return
     */
    public String test1() {
        return offerAPI.home();
    }

    /**
     * Тащим сообщение из микросервиса сделок
     *
     * @return
     */
    public String test2() {
        return offerAPI.test();
    }

    /**
     * Тащим сообщение из микросервиса пользователей
     *
     * @return
     */
    public String test3() {
        return userAPI.home();
    }

    /**
     * Тащим сообщение из микросервиса пользователей
     *
     * @return
     */
    public String test4() {
        return userAPI.test();
    }
}
