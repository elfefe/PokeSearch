@file:OptIn(ExperimentalSerializationApi::class)

package com.elfefe.pokesearch.mvvm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames


@kotlinx.serialization.Serializable
@Parcelize
data class Specie (
    @JsonNames("base_happiness")
    val baseHappiness: Long,

    @JsonNames("capture_rate")
    val captureRate: Long,

    val color: Color,

    @JsonNames("egg_groups")
    val eggGroups: List<Color>,

    @JsonNames("evolution_chain")
    val evolutionChain: EvolutionChain,

    @JsonNames("evolves_from_species")
    val evolvesFromSpecies: Color?,

    @JsonNames("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>,

    @JsonNames("form_descriptions")
    val formDescriptions: List<String?>,

    @JsonNames("forms_switchable")
    val formsSwitchable: Boolean,

    @JsonNames("gender_rate")
    val genderRate: Long,

    val genera: List<Genus>,
    val generation: Color,

    @JsonNames("growth_rate")
    val growthRate: Color,

    val habitat: Color,

    @JsonNames("has_gender_differences")
    val hasGenderDifferences: Boolean,

    @JsonNames("hatch_counter")
    val hatchCounter: Long,

    val id: Long,

    @JsonNames("is_baby")
    val isBaby: Boolean,

    @JsonNames("is_legendary")
    val isLegendary: Boolean,

    @JsonNames("is_mythical")
    val isMythical: Boolean,

    val name: String,
    val names: List<Name>,
    val order: Long,

    @JsonNames("pal_park_encounters")
    val palParkEncounters: List<PalParkEncounter>,

    @JsonNames("pokedex_numbers")
    val pokedexNumbers: List<PokedexNumber>,

    val shape: Color,
    val varieties: List<Variety>
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Color (
    val name: String,
    val url: String
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class EvolutionChain (
    val url: String
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class FlavorTextEntry (
    @JsonNames("flavor_text")
    val flavorText: String,

    val language: Color,
    val version: Color
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Genus (
    val genus: String,
    val language: Color
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Name (
    val language: Color,
    val name: String
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class PalParkEncounter (
    val area: Color,

    @JsonNames("base_score")
    val baseScore: Long,

    val rate: Long
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class PokedexNumber (
    @JsonNames("entry_number")
    val entryNumber: Long,

    val pokedex: Color
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Variety (
    @JsonNames("is_default")
    val isDefault: Boolean,

    val pokemon: Color
): Parcelable
