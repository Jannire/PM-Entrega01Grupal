package pe.edu.ulima.pm20232.aulavirtual.services

import pe.edu.ulima.pm20232.aulavirtual.configs.BASE_URL
import pe.edu.ulima.pm20232.aulavirtual.models.Member

class MemberService {
<<<<<<< Updated upstream
    private var memberList: ArrayList<Member> = ArrayList<Member>()

    constructor(){
        val baseUrl = BASE_URL
        memberList.add(Member(id = 1, code = 20180038, names = "ALCALA ISUIZA", lastNames = "ANGEL ADRIAN", email = "20180038@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345678"))
        memberList.add(Member(id = 2, code = 20202370, names = "ARROYO LEON", lastNames = "DIEGO ENRIQUE", email = "20202370@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345679"))
        memberList.add(Member(id = 3, code = 20171869, names = "BARDALES CHIHUANHUAYLLA", lastNames = "JORGE LUIS", email = "20171869@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345680"))
        memberList.add(Member(id = 4, code = 20192566, names = "CARRION SAAVEDRA", lastNames = "DAVID RODRIGO", email = "20192566@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345681"))
        memberList.add(Member(id = 5, code = 20202712, names = "CARTOLIN YANQUE", lastNames = "MARIO ALEXANDER", email = "20202712@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345682"))
        memberList.add(Member(id = 6, code = 20184660, names = "CUYA SANCHEZ", lastNames = "ANGEL OSCAR", email = "20184660@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345683"))
        memberList.add(Member(id = 7, code = 20200711, names = "DUARTE ROMERO", lastNames = "ADRIAN", email = "20200711@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345684"))
        memberList.add(Member(id = 8, code = 20194065, names = "ESPINOZA ARROYO", lastNames = "JESUS MIGUEL", email = "20194065@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345685"))
        memberList.add(Member(id = 9, code = 20192303, names = "GIL VELARDE", lastNames = "RAFAEL ALFONSO", email = "20192303@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345686"))
        memberList.add(Member(id = 10, code = 20190857, names = "GOMEZ LOPEZ", lastNames = "ALEJANDRO", email = "20190857@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345687"))
        memberList.add(Member(id = 11, code = 20182686, names = "GUILLEN CHARA", lastNames = "LUIS ANGELO", email = "20182686@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345688"))
        memberList.add(Member(id = 12, code = 20142881, names = "IZAGUIRRE CASTRO", lastNames = "ANDONI TOMAS", email = "20142881@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345689"))
        memberList.add(Member(id = 13, code = 20192985, names = "LINARES ALZAMORA", lastNames = "RODRIGO GABRIEL", email = "20192985@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345690"))
        memberList.add(Member(id = 14, code = 20201166, names = "LIVIAS VIGIL", lastNames = "AARON WAGNER LINCOLN", email = "20201166@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345691"))
        memberList.add(Member(id = 15, code = 20202407, names = "MENESES GUTIERREZ", lastNames = "HECTOR JOSE", email = "20202407@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345692"))
        memberList.add(Member(id = 16, code = 30230242, names = "MESTANZA CABRERA", lastNames = "AXEL SMITH", email = "30230242@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345693"))
        memberList.add(Member(id = 17, code = 20191291, names = "MIGLIORI RUIZ", lastNames = "RENATO MARCELO", email = "20191291@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345694"))
        memberList.add(Member(id = 18, code = 20191301, names = "MIÑAN PANDURO", lastNames = "EDUARDO PATRICK", email = "20191301@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345695"))
        memberList.add(Member(id = 19, code = 20191412, names = "OBLITAS MANTILLA", lastNames = "JOHAN ANDRES", email = "20191412@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345696"))
        memberList.add(Member(id = 20, code = 20152154, names = "OROPEZA MEDRANO", lastNames = "BRAYAN JEANPIERE", email = "20152154@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345697"))
        memberList.add(Member(id = 21, code = 20191937, names = "SOLIMANO PRINA", lastNames = "LEONARDO NAZIR", email = "20191937@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345698"))
        memberList.add(Member(id = 22, code = 20203668, names = "SOTELO GOMEZ", lastNames = "FRANCO", email = "20203668@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345699"))
        memberList.add(Member(id = 23, code = 20203703, names = "TINCO BELLIDO", lastNames = "JEAN PIERRE", email = "20203703@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345700"))
        memberList.add(Member(id = 24, code = 20192003, names = "TORRES BALMACEDA", lastNames = "SEBASTIAN", email = "20192003@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345701"))
        memberList.add(Member(id = 25, code = 20193553, names = "TRUJILLO DELGADO", lastNames = "JANNIRE ASHLEY", email = "20193553@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345702"))
        memberList.add(Member(id = 26, code = 20162609, names = "VARGAS AROSTEGUI", lastNames = "ERIK RICARDO", email = "20162609@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345703"))
        memberList.add(Member(id = 27, code = 20172768, names = "VELARDE HUAMAN", lastNames = "HECTOR EUSEBIO", email = "20172768@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345704"))
        memberList.add(Member(id = 28, code = 20183460, names = "ZAPATA ALBUJAR", lastNames = "PAOLO GIULIANO", email = "20183460@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "${baseUrl}profile-default.png", levelId = 1, dni = "12345705"))
    }
    fun getMemberLastNames(id: Int): String? {
        val member = memberList.find { it.id == id }
        return member?.lastNames
    }

    fun getMemberNames(id: Int): String? {
        val member = memberList.find { it.id == id }
        return member?.names
    }

    fun getMemberDni(id: Int): String? {
        val member = memberList.find { it.id == id }
        return member?.dni
    }


    fun getMemberLevelId(id: Int): Int? {
        val member = memberList.find { it.id == id }
        return member?.levelId
    }

    fun getMemberImageUrl(id: Int): String? {
        val member = memberList.find { it.id == id }
        return member?.imageUrl
    }

    fun getMemberEmailByCode(id: Int): String? {
        val member = memberList.find { it.id == id }
        return member?.email
    }

    fun getMemberPhoneByCode(id: Int): String? {
        val member = memberList.find { it.id == id }
        return member?.phone
    }

}
=======
    var memberList: ArrayList<Member> = ArrayList<Member>()

    constructor(){
        val baseUrl = BASE_URL
        memberList.add(Member(id = 1, code = 20180038, names = "ALCALA ISUIZA", lastNames = "ANGEL ADRIAN", email = "20180038@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345678"))
        memberList.add(Member(id = 2, code = 20202370, names = "ARROYO LEON", lastNames = "DIEGO ENRIQUE", email = "20202370@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345679"))
        memberList.add(Member(id = 3, code = 20171869, names = "BARDALES CHIHUANHUAYLLA", lastNames = "JORGE LUIS", email = "20171869@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345680"))
        memberList.add(Member(id = 4, code = 20192566, names = "CARRION SAAVEDRA", lastNames = "DAVID RODRIGO", email = "20192566@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345681"))
        memberList.add(Member(id = 5, code = 20202712, names = "CARTOLIN YANQUE", lastNames = "MARIO ALEXANDER", email = "20202712@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345682"))
        memberList.add(Member(id = 6, code = 20184660, names = "CUYA SANCHEZ", lastNames = "ANGEL OSCAR", email = "20184660@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345683"))
        memberList.add(Member(id = 7, code = 20200711, names = "DUARTE ROMERO", lastNames = "ADRIAN", email = "20200711@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345684"))
        memberList.add(Member(id = 8, code = 20194065, names = "ESPINOZA ARROYO", lastNames = "JESUS MIGUEL", email = "20194065@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345685"))
        memberList.add(Member(id = 9, code = 20192303, names = "GIL VELARDE", lastNames = "RAFAEL ALFONSO", email = "20192303@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345686"))
        memberList.add(Member(id = 10, code = 20190857, names = "GOMEZ LOPEZ", lastNames = "ALEJANDRO", email = "20190857@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345687"))
        memberList.add(Member(id = 11, code = 20182686, names = "GUILLEN CHARA", lastNames = "LUIS ANGELO", email = "20182686@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345688"))
        memberList.add(Member(id = 12, code = 20142881, names = "IZAGUIRRE CASTRO", lastNames = "ANDONI TOMAS", email = "20142881@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345689"))
        memberList.add(Member(id = 13, code = 20192985, names = "LINARES ALZAMORA", lastNames = "RODRIGO GABRIEL", email = "20192985@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345690"))
        memberList.add(Member(id = 14, code = 20201166, names = "LIVIAS VIGIL", lastNames = "AARON WAGNER LINCOLN", email = "20201166@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345691"))
        memberList.add(Member(id = 15, code = 20202407, names = "MENESES GUTIERREZ", lastNames = "HECTOR JOSE", email = "20202407@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345692"))
        memberList.add(Member(id = 16, code = 30230242, names = "MESTANZA CABRERA", lastNames = "AXEL SMITH", email = "30230242@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345693"))
        memberList.add(Member(id = 17, code = 20191291, names = "MIGLIORI RUIZ", lastNames = "RENATO MARCELO", email = "20191291@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345694"))
        memberList.add(Member(id = 18, code = 20191301, names = "MIÑAN PANDURO", lastNames = "EDUARDO PATRICK", email = "20191301@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345695"))
        memberList.add(Member(id = 19, code = 20191412, names = "OBLITAS MANTILLA", lastNames = "JOHAN ANDRES", email = "20191412@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345696"))
        memberList.add(Member(id = 20, code = 20152154, names = "OROPEZA MEDRANO", lastNames = "BRAYAN JEANPIERE", email = "20152154@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345697"))
        memberList.add(Member(id = 21, code = 20191937, names = "SOLIMANO PRINA", lastNames = "LEONARDO NAZIR", email = "20191937@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345698"))
        memberList.add(Member(id = 22, code = 20203668, names = "SOTELO GOMEZ", lastNames = "FRANCO", email = "20203668@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345699"))
        memberList.add(Member(id = 23, code = 20203703, names = "TINCO BELLIDO", lastNames = "JEAN PIERRE", email = "20203703@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345700"))
        memberList.add(Member(id = 24, code = 20192003, names = "TORRES BALMACEDA", lastNames = "SEBASTIAN", email = "20192003@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345701"))
        memberList.add(Member(id = 25, code = 20193553, names = "TRUJILLO DELGADO", lastNames = "JANNIRE ASHLEY", email = "20193553@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345702"))
        memberList.add(Member(id = 26, code = 20162609, names = "VARGAS AROSTEGUI", lastNames = "ERIK RICARDO", email = "20162609@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345703"))
        memberList.add(Member(id = 27, code = 20172768, names = "VELARDE HUAMAN", lastNames = "HECTOR EUSEBIO", email = "20172768@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345704"))
        memberList.add(Member(id = 28, code = 20183460, names = "ZAPATA ALBUJAR", lastNames = "PAOLO GIULIANO", email = "20183460@aloe.ulima.edu.pe", phone="999-888-777", imageUrl = "{baseUrl}profile-default.png", levelId = 1, dni = "12345705"))
    }

    // Get member details by ID
    fun getMemberById(id: Int): Member? {
        return memberList.find { it.id == id }
    }

    // Get member attribute by ID methods
    fun getMemberCodeById(id: Int): Int? {
        val member = getMemberById(id)
        return member?.code
    }

    fun getMemberNamesById(id: Int): String? {
        val member = getMemberById(id)
        return member?.names
    }

    fun getMemberLastNamesById(id: Int): String? {
        val member = getMemberById(id)
        return member?.lastNames
    }

    fun getMemberEmailById(id: Int): String? {
        val member = getMemberById(id)
        return member?.email
    }

    fun getMemberPhoneById(id: Int): String? {
        val member = getMemberById(id)
        return member?.phone
    }

    fun getMemberImageUrlById(id: Int, baseUrl: String): String? {
        val member = getMemberById(id)
        return member?.imageUrl?.replace("{baseUrl}", baseUrl)
    }

    fun getMemberLevelIdById(id: Int): Int? {
        val member = getMemberById(id)
        return member?.levelId
    }

    fun getMemberDniById(id: Int): String? {
        val member = getMemberById(id)
        return member?.dni
    }
}


>>>>>>> Stashed changes
