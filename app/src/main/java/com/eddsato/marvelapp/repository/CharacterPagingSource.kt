package com.eddsato.marvelapp.repository

import androidx.paging.PagingSource
import com.eddsato.marvelapp.BuildConfig
import com.eddsato.marvelapp.entity.Character
import com.eddsato.marvelapp.infrastructure.extensions.md5
import com.eddsato.marvelapp.infrastructure.network.MarvelAPI
import com.eddsato.marvelapp.utils.Utils
import retrofit2.HttpException
import java.io.IOException
import java.util.*

private const val MARVEL_STARTING_PAGE_INDEX = 0

class CharacterPagingSource(
        private val api: MarvelAPI
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val publicApiKey = BuildConfig.MARVEL_PUBLIC_API_KEY
        val privateApiKey = BuildConfig.MARVEL_PRIVATE_API_KEY
        val timestamp = Utils.formatDate(
            Utils.SIMPLE_DATE_FORMAT_ISO_8601,
            Calendar.getInstance().time
        )
        val hash = timestamp + privateApiKey + publicApiKey
        val position = params.key ?: MARVEL_STARTING_PAGE_INDEX

        return try {
            val response = api.getCharacterList(
                timestamp,
                publicApiKey,
                hash.md5(),
                position,
                params.loadSize
            )

            val characters = response.data.results
            LoadResult.Page(
                    data = characters,
                    prevKey = if (position == MARVEL_STARTING_PAGE_INDEX) null else position - 1,
                    nextKey = if (characters.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}
