package com.naver.hackday.trendapi.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;

        import com.naver.hackday.trendapi.model.Test;
        import com.naver.hackday.trendapi.model.TrendKeyword;

        import java.time.LocalDateTime;

/**
 * @author SaeHan Kim
 * @since 2018-11-19
 */
@RepositoryRestResource(path = "trendKeyword", collectionResourceRel = "trendKeyword")
public interface TrendKeywordRepository extends JpaRepository<TrendKeyword, Long> {
    TrendKeyword findTopByOrderByCreatedTimeDesc();
}
