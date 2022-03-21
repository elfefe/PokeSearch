@file:OptIn(ExperimentalSerializationApi::class)

package com.elfefe.pokesearch.mvvm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

@kotlinx.serialization.Serializable
@Parcelize
data class PokemonSpecie(
    val pokemon: Pokemon,
    val specie: Specie
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class PokeFilter(
    val count: Long,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokeLink>
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Pokemon(
    val abilities: List<Ability>,

    @JsonNames("base_experience")
    val baseExperience: Long,

    val forms: List<PokeLink?>,

    @JsonNames("game_indices")
    val gameIndices: List<GameIndex>,

    val height: Long,

    @JsonNames("held_items")
    val heldItems: List<HeldItem>,

    val id: Long,

    @JsonNames("is_default")
    val isDefault: Boolean,

    @JsonNames("location_area_encounters")
    val locationAreaEncounters: String,

    val moves: List<Move>,
    val name: String,
    val order: Long,

    @JsonNames("past_types")
    val pastTypes: List<PastType?>,

    val species: PokeLink?,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Long
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class PastType (
    val generation: PokeLink?,
    val types: List<Type>
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Ability (
    val ability: PokeLink?,

    @JsonNames("is_hidden")
    val isHidden: Boolean,

    val slot: Long
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class PokeLink(
    val name: String,
    val url: String
): Parcelable


@kotlinx.serialization.Serializable
@Parcelize
data class GameIndex (
    @JsonNames("game_index")
    val gameIndex: Long,

    val version: PokeLink?
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class HeldItem (
    val item: PokeLink?,

    @JsonNames("version_details")
    val versionDetails: List<VersionDetail>
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class VersionDetail (
    val rarity: Long,
    val version: PokeLink?
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Move (
    val move: PokeLink?,

    @JsonNames("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class VersionGroupDetail (
    @JsonNames("level_learned_at")
    val levelLearnedAt: Long,

    @JsonNames("move_learn_method")
    val moveLearnMethod: PokeLink?,

    @JsonNames("version_group")
    val versionGroup: PokeLink?
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class GenerationV (
    @JsonNames("black-white")
    val blackWhite: Sprites
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class GenerationIv (
    @JsonNames("diamond-pearl")
    val diamondPearl: Sprites,

    @JsonNames("heartgold-soulsilver")
    val heartgoldSoulsilver: Sprites,

    val platinum: Sprites
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Versions(
    @JsonNames("generation-i")
    val generationI: GenerationI,

    @JsonNames("generation-ii")
    val generationIi: GenerationIi,

    @JsonNames("generation-iii")
    val generationIii: GenerationIii,

    @JsonNames("generation-iv")
    val generationIv: GenerationIv,

    @JsonNames("generation-v")
    val generationV: GenerationV,

    @JsonNames("generation-vi")
    val generationVi: Map<String, Home>,

    @JsonNames("generation-vii")
    val generationVii: GenerationVii,

    @JsonNames("generation-viii")
    val generationViii: GenerationViii
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Sprites(
    @JsonNames("back_default")
    val back_default: String? = null,

    @JsonNames("back_female")
    val back_female: String? = null,

    @JsonNames("back_shiny")
    val back_shiny: String? = null,

    @JsonNames("back_shiny_female")
    val back_shiny_female: String? = null,

    @JsonNames("front_default")
    val front_default: String? = null,

    @JsonNames("front_female")
    val front_female: String? = null,

    @JsonNames("front_shiny")
    val frontShiny: String? = null,

    @JsonNames("front_shiny_female")
    val frontShinyFemale: String? = null,

    val other: Other? = null,
    val versions: Versions? = null,
    val animated: Sprites? = null
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class GenerationI(
    @JsonNames("red-blue")
    val redBlue: RedBlue,

    val yellow: RedBlue
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class RedBlue(
    @JsonNames("back_default")
    val backDefault: String? = null,

    @JsonNames("back_gray")
    val backGray: String? = null,

    @JsonNames("back_transparent")
    val backTransparent: String? = null,

    @JsonNames("front_default")
    val frontDefault: String? = null,

    @JsonNames("front_gray")
    val frontGray: String? = null,

    @JsonNames("front_transparent")
    val frontTransparent: String? = null
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Gold
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Crystal(
    @JsonNames("back_default")
    val backDefault: String? = null,

    @JsonNames("back_shiny")
    val backShiny: String? = null,

    @JsonNames("back_shiny_transparent")
    val backShinyTransparent: String? = null,

    @JsonNames("back_transparent")
    val backTransparent: String? = null,

    @JsonNames("front_default")
    val frontDefault: String? = null,

    @JsonNames("front_shiny")
    val frontShiny: String? = null,

    @JsonNames("front_shiny_transparent")
    val frontShinyTransparent: String? = null,

    @JsonNames("front_transparent")
    val frontTransparent: String? = null
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Gold(
    @JsonNames("back_default")
    val backDefault: String? = null,

    @JsonNames("back_shiny")
    val backShiny: String? = null,

    @JsonNames("front_default")
    val frontDefault: String? = null,

    @JsonNames("front_shiny")
    val frontShiny: String? = null,

    @JsonNames("front_transparent")
    val frontTransparent: String? = null
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class GenerationIii(
    val emerald: Emerald,

    @JsonNames("firered-leafgreen")
    val fireredLeafgreen: Gold,

    @JsonNames("ruby-sapphire")
    val rubySapphire: Gold
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Emerald(
    @JsonNames("front_default")
    val frontDefault: String,

    @JsonNames("front_shiny")
    val frontShiny: String
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Home(
    @JsonNames("front_default")
    val frontDefault: String? = null,

    @JsonNames("front_female")
    val frontFemale: String? = null,

    @JsonNames("front_shiny")
    val frontShiny: String? = null,

    @JsonNames("front_shiny_female")
    val frontShinyFemale: String? = null
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class GenerationVii(
    val icons: DreamWorld,

    @JsonNames("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: Home
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class DreamWorld(
    @JsonNames("front_default")
    val frontDefault: String? = null,

    @JsonNames("front_female")
    val frontFemale: String? = null
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class GenerationViii(
    val icons: DreamWorld
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Other(
    @JsonNames("dream_world")
    val dreamWorld: DreamWorld,

    val home: Home,

    @JsonNames("official-artwork")
    val officialArtwork: OfficialArtwork
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class OfficialArtwork(
    @JsonNames("front_default")
    val frontDefault: String?
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Stat(
    @JsonNames("base_stat")
    val baseStat: Long,

    val effort: Long,
    val stat: PokeLink?
): Parcelable

@kotlinx.serialization.Serializable
@Parcelize
data class Type(
    val slot: Long,
    val type: PokeLink?
): Parcelable