package com.diskvarko.androidacademyapp.network.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Configuration(
		val images: Images,

		)

@Serializable
data class Images(
		@SerialName("base_url")
		val baseURL: String,

		@SerialName("secure_base_url")
		val secureBaseURL: String,

		@SerialName("backdrop_sizes")
		val backdropSizes: List<String>,

		@SerialName("logo_sizes")
		val logoSizes: List<String>,

		@SerialName("poster_sizes")
		val posterSizes: List<String>,

		@SerialName("profile_sizes")
		val profileSizes: List<String>,

		)
