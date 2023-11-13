package pe.edu.ulima.pm20232.aulavirtual.services

import pe.edu.ulima.pm20232.aulavirtual.models.BodyPart

class BodyPartService {
    var bodyPartList: ArrayList<BodyPart> = ArrayList<BodyPart>()

    constructor(){
        bodyPartList.add(BodyPart(id = 1, name = "ABDOMEN"))
        bodyPartList.add(BodyPart(id = 2, name = "PIERNAS"))
        bodyPartList.add(BodyPart(id = 3, name = "PANTORRILLA"))
        bodyPartList.add(BodyPart(id = 4, name = "PECTORAL"))
        bodyPartList.add(BodyPart(id = 5, name = "ESPALDA"))
        bodyPartList.add(BodyPart(id = 6, name = "HOMBROS"))
        bodyPartList.add(BodyPart(id = 7, name = "BICEPS"))
        bodyPartList.add(BodyPart(id = 8, name = "TRICEPS"))
    }
}