package ru.practicum.android.diploma.domain.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.practicum.android.diploma.domain.api.search.SearchInteractor
import ru.practicum.android.diploma.domain.api.search.SearchRepository
import ru.practicum.android.diploma.domain.models.Vacancies
import ru.practicum.android.diploma.domain.models.Vacancy
import ru.practicum.android.diploma.util.Resource

class SearchInteractorImpl(private val searchRepository: SearchRepository) : SearchInteractor {
    override fun searchVacancies(vacancy: String): Flow<Pair<Vacancies?, String?>> {
        return searchRepository.searchVacancies(vacancy).map { result ->
            when (result) {
                is Resource.Success -> {
                    Pair(result.data, null)
                }

                is Resource.Error -> {
                    Pair(null, result.message)
                }
            }
        }
    }

    override fun add(it: Vacancy) {
        searchRepository.add(it)
    }
}
