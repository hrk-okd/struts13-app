package my.struts.presentation.controller;

import lombok.RequiredArgsConstructor;
import my.struts.presentation.form.EarthquakeFeedForm;
import my.struts.domain.model.JmaFeed;
import my.struts.usecase.EarthquakeUsecase;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ログイン処理を行います。
 */
@Component
@RequiredArgsConstructor
public class DisplayEarthquakeController implements ActionController {

    /**
     * 地震情報取得サービスです。
     */
    private final EarthquakeUsecase earthquakeUsecase;

    /**
     * モデルマッパーです。
     */
    private final ModelMapper modelMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute(@NonNull final Action action,
            @NonNull final ActionMapping mapping,
            @NonNull final ActionForm form,
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response) {

        JmaFeed feed = earthquakeUsecase.getFeed();
        if (Objects.isNull(feed) || CollectionUtils.isEmpty(feed.getEntryList())) {
            return null;
        }

        List<EarthquakeFeedForm.Entry> formEntryList = feed.getEntryList().stream()
                .map(entry -> modelMapper.map(entry, EarthquakeFeedForm.Entry.class))
                .collect(Collectors.toList());
        EarthquakeFeedForm output = (EarthquakeFeedForm)form;
        output.setEntryList(formEntryList);

        return "success";
    }


}