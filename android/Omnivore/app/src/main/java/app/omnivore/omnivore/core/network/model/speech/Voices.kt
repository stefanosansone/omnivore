package app.omnivore.omnivore.core.network.model.speech

object Voices {
    fun isUltraRealisticVoice(voiceKey: String): Boolean {
        return UltraPairs.any { it.firstKey == voiceKey || it.secondKey == voiceKey }
    }

    fun isOpenAIVoice(voiceKey: String): Boolean {
        return voiceKey.startsWith("openai-")
    }

    private val English = VoiceLanguage(
        key = "en",
        name = "English",
        defaultVoice = "en-US-ChristopherNeural",
        categories = listOf(
            VoiceCategory.EN_US, VoiceCategory.EN_AU, VoiceCategory.EN_CA,
            VoiceCategory.EN_IE, VoiceCategory.EN_IN, VoiceCategory.EN_SG,
            VoiceCategory.EN_UK
        )
    )

    val Languages = listOf(
        English,
        VoiceLanguage(key = "zh", name = "Chinese", defaultVoice = "zh-CN-XiaochenNeural", categories = listOf(VoiceCategory.ZH_CN)),
        VoiceLanguage(key = "de", name = "German", defaultVoice = "de-CH-JanNeural", categories = listOf(VoiceCategory.DE_DE)),
        VoiceLanguage(key = "fr", name = "French", defaultVoice = "fr-FR-HenriNeural", categories = listOf(VoiceCategory.FR_FR)),
        VoiceLanguage(key = "hi", name = "Hindi", defaultVoice = "hi-IN-MadhurNeural", categories = listOf(VoiceCategory.HI_IN)),
        VoiceLanguage(key = "it", name = "Italian", defaultVoice = "it-IT-BenignoNeural", categories = listOf(VoiceCategory.IT_IT)),
        VoiceLanguage(key = "ja", name = "Japanese", defaultVoice = "ja-JP-NanamiNeural", categories = listOf(VoiceCategory.JA_JP)),
        VoiceLanguage(key = "es", name = "Spanish", defaultVoice = "es-ES-AlvaroNeural", categories = listOf(VoiceCategory.ES_ES)),
        VoiceLanguage(key = "nl", name = "Dutch", defaultVoice = "nl-NL-XiaochenNeural", categories = listOf(VoiceCategory.NL_NL)),
        VoiceLanguage(key = "pt", name = "Portuguese", defaultVoice = "pt-BR-AntonioNeural", categories = listOf(VoiceCategory.PT_BR)),
        VoiceLanguage(key = "ta", name = "Tamil", defaultVoice = "ta-IN-PallaviNeural", categories = listOf(VoiceCategory.TA_IN, VoiceCategory.TA_LK, VoiceCategory.TA_MY, VoiceCategory.TA_SG))
    )

    val Pairs = listOf(
        VoicePair(firstKey = "openai-alloy", secondKey = "openai-echo", firstName = "Alloy", secondName = "Echo", language = "en-US", category = VoiceCategory.EN_US),
        VoicePair(firstKey = "openai-fable", secondKey = "openai-onyx", firstName = "Fable", secondName = "Onyx", language = "en-US", category = VoiceCategory.EN_US),
        VoicePair(firstKey = "openai-nova", secondKey = "openai-shimmer", firstName = "Nova", secondName = "Shimmer", language = "en-US", category = VoiceCategory.EN_US),

        VoicePair(firstKey = "en-US-JennyNeural", secondKey = "en-US-BrandonNeural", firstName = "Jenny", secondName = "Brandon", language = "en-US", category = VoiceCategory.EN_US),
        VoicePair(firstKey = "en-US-CoraNeural", secondKey = "en-US-ChristopherNeural", firstName = "Cora", secondName = "Christopher", language = "en-US", category = VoiceCategory.EN_US),
        VoicePair(firstKey = "en-US-ElizabethNeural", secondKey = "en-US-EricNeural", firstName = "Elizabeth", secondName = "Eric", language = "en-US", category = VoiceCategory.EN_US),
        VoicePair(firstKey = "en-CA-ClaraNeural", secondKey = "en-CA-LiamNeural", firstName = "Clara", secondName = "Liam", language = "en-CA", category = VoiceCategory.EN_CA),
        VoicePair(firstKey = "en-GB-LibbyNeural", secondKey = "en-GB-EthanNeural", firstName = "Libby", secondName = "Ethan", language = "en-GB", category = VoiceCategory.EN_UK),
        VoicePair(firstKey = "en-AU-NatashaNeural", secondKey = "en-AU-WilliamNeural", firstName = "Natasha", secondName = "William", language = "en-AU", category = VoiceCategory.EN_AU),
        VoicePair(firstKey = "en-IE-ConnorNeural", secondKey = "en-IE-EmilyNeural", firstName = "Connor", secondName = "Emily", language = "en-IE", category = VoiceCategory.EN_IE),
        VoicePair(firstKey = "en-IN-NeerjaNeural", secondKey = "en-IN-PrabhatNeural", firstName = "Neerja", secondName = "Prabhat", language = "en-IN", category = VoiceCategory.EN_IN),
        VoicePair(firstKey = "en-SG-LunaNeural", secondKey = "en-SG-WayneNeural", firstName = "Luna", secondName = "Wayne", language = "en-SG", category = VoiceCategory.EN_SG),
        VoicePair(firstKey = "fr-FR-HenriNeural", secondKey = "fr-FR-DeniseNeural", firstName = "Henri", secondName = "Denise", language = "fr-FR", category = VoiceCategory.FR_FR),
        VoicePair(firstKey = "zh-CN-XiaochenNeural", secondKey = "zh-CN-XiaohanNeural", firstName = "Xiaochen", secondName = "Xiaohan", language = "zh-CN", category = VoiceCategory.ZH_CN),
        VoicePair(firstKey = "zh-CN-XiaoxiaoNeural", secondKey = "zh-CN-YunyangNeural", firstName = "Xiaoxiao", secondName = "Yunyang", language = "zh-CN", category = VoiceCategory.ZH_CN),
        VoicePair(firstKey = "zh-CN-YunxiNeural", secondKey = "zh-CN-XiaoyiNeural", firstName = "Yunxi", secondName = "Xiaoyi", language = "zh-CN", category = VoiceCategory.ZH_CN),
        VoicePair(firstKey = "es-ES-AlvaroNeural", secondKey = "es-ES-ElviraNeural", firstName = "Alvaro", secondName = "Elvira", language = "es-ES", category = VoiceCategory.ES_ES),
        VoicePair(firstKey = "de-CH-LeniNeural", secondKey = "de-DE-KatjaNeural", firstName = "Leni", secondName = "Katja", language = "de-DE", category = VoiceCategory.DE_DE),
        VoicePair(firstKey = "de-DE-AmalaNeural", secondKey = "de-DE-BerndNeural", firstName = "Amala", secondName = "Bernd", language = "de-DE", category = VoiceCategory.DE_DE),
        VoicePair(firstKey = "de-DE-ChristophNeural", secondKey = "de-DE-LouisaNeural", firstName = "Christoph", secondName = "Louisa", language = "de-DE", category = VoiceCategory.DE_DE),
        VoicePair(firstKey = "ja-JP-NanamiNeural", secondKey = "ja-JP-KeitaNeural", firstName = "Nanami", secondName = "Keita", language = "ja-JP", category = VoiceCategory.JA_JP),
        VoicePair(firstKey = "hi-IN-MadhurNeural", secondKey = "hi-IN-SwaraNeural", firstName = "Madhur", secondName = "Swara", language = "hi-IN", category = VoiceCategory.HI_IN),
        VoicePair(firstKey = "pt-BR-AntonioNeural", secondKey = "pt-BR-BrendaNeural", firstName = "Antonio", secondName = "Brenda", language = "pt-BR", category = VoiceCategory.PT_BR),
        VoicePair(firstKey = "ta-IN-PallaviNeural", secondKey = "ta-IN-ValluvarNeural", firstName = "Pallavi", secondName = "Valluvar", language = "ta-IN", category = VoiceCategory.TA_IN),
        VoicePair(firstKey = "ta-LK-KumarNeural", secondKey = "ta-LK-SaranyaNeural", firstName = "Kumar", secondName = "Saranya", language = "ta-LK", category = VoiceCategory.TA_LK),
        VoicePair(firstKey = "ta-MY-KaniNeural", secondKey = "ta-MY-SuryaNeural", firstName = "Kani", secondName = "Surya", language = "ta-MY", category = VoiceCategory.TA_MY),
        VoicePair(firstKey = "ta-SG-AnbuNeural", secondKey = "ta-SG-VenbaNeural", firstName = "Anbu", secondName = "Venba", language = "ta-SG", category = VoiceCategory.TA_SG),
        VoicePair(firstKey = "it-IT-BenignoNeural", secondKey = "it-IT-IsabellaNeural", firstName = "Benigno", secondName = "Isabella", language = "it-IT", category = VoiceCategory.IT_IT),
        VoicePair(firstKey = "nl-NL-MaartenNeural", secondKey = "nl-NL-FennaNeural", firstName = "Maarten", secondName = "Fenna", language = "nl-NL", category = VoiceCategory.NL_NL)
    )

    private val UltraPairs = listOf(
        VoicePair(firstKey = "Antoni", secondKey = "Serena", firstName = "Antoni", secondName = "Serena", language = "en-US", category = VoiceCategory.EN_US),
        VoicePair(firstKey = "Daniel", secondKey = "Dorothy", firstName = "Daniel", secondName = "Dorothy", language = "en-GB", category = VoiceCategory.EN_UK),
        VoicePair(firstKey = "Michael", secondKey = "Matilda", firstName = "Michael", secondName = "Matilda", language = "en-US", category = VoiceCategory.EN_US),
        VoicePair(firstKey = "Josh", secondKey = "Bella", firstName = "Josh", secondName = "Bella", language = "en-US", category = VoiceCategory.EN_US)
    )
}

enum class VoiceCategory(val displayName: String) {
    EN_US("English (US)"),
    EN_AU("English (Australia)"),
    EN_CA("English (Canada)"),
    EN_IE("English (Ireland)"),
    EN_IN("English (India)"),
    EN_SG("English (Singapore)"),
    EN_UK("English (UK)"),
    FR_FR("French (France)"),
    DE_DE("German (Germany)"),
    HI_IN("Hindi (India)"),
    IT_IT("Italian (Italy)"),
    ES_ES("Spanish (Spain)"),
    JA_JP("Japanese (Japan)"),
    NL_NL("Dutch (Netherlands)"),
    PT_BR("Portuguese (Brazil)"),
    TA_IN("Tamil (India)"),
    TA_LK("Tamil (Sri Lanka)"),
    TA_MY("Tamil (Malaysia)"),
    TA_SG("Tamil (Singapore)"),
    ZH_CN("Chinese (China Mainland)");

    companion object {
        fun fromDisplayName(displayName: String): VoiceCategory? {
            return entries.find { it.displayName == displayName }
        }
    }
}

data class VoiceLanguage(
    val key: String,
    val name: String,
    val defaultVoice: String,
    val categories: List<VoiceCategory>
)

data class VoiceItem(
    val name: String,
    val key: String,
    val category: VoiceCategory,
    val selected: Boolean
)

data class VoicePair(
    val firstKey: String,
    val secondKey: String,
    val firstName: String,
    val secondName: String,
    val language: String,
    val category: VoiceCategory
)
