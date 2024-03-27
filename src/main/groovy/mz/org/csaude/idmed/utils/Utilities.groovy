package mz.org.csaude.idmed.utils


import mz.org.csaude.idmed.domains.clinic.Clinic

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.Collator
import java.text.Normalizer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Utilities {
    private static Utilities instance

    private Utilities() {
    }

    static Utilities getInstance() {
        if (instance == null) {
            instance = new Utilities()
        }
        return instance
    }

    static boolean stringHasValue(String string) {
        string != null && !string.isEmpty() && string.trim().length() > 0
    }

    static String ensureXCaractersOnNumber(long number, int x) {
        String formatedNumber = ""
        int numberOfCharacterToIncrise = 0

        formatedNumber = number.toString()

        numberOfCharacterToIncrise = x - formatedNumber.length()

        for (int i = 0; i < numberOfCharacterToIncrise; i++) {
            formatedNumber = "0" + formatedNumber
        }

        formatedNumber
    }

    static String concatStrings(String currentString, String toConcant, String scapeStr) {
        if (!stringHasValue(currentString)) {
            return toConcant
        }

        if (!stringHasValue(toConcant)) {
            return currentString
        }

        currentString + scapeStr + toConcant
    }

    static boolean isStringIn(String value, String... inValues) {
        if (inValues == null || value == null) {
            return false
        }

        inValues.each { str ->
            if (value.equals(str)) {
                return true
            }
        }

        false
    }

    static boolean listHasElements(ArrayList<?> list) {
        list != null && !list.isEmpty() && list.size() > 0
    }

    static <T extends Object> T findOnArray(List<T> list, T toFind) {
        list.each { o ->
            if (o.equals(toFind)) {
                return o
            }
        }
        null
    }

    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str)
            true
        } catch (NumberFormatException e) {
            false
        }
    }

    boolean isValidDate(String dateStr) {
        try {
            LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch (Exception e) {
            false
        }
    }

    static String generateUUID() {
        UUID.randomUUID().toString()
    }

    static String generateID(Clinic clinic) {
        "${clinic.getCode()}-${generateUUID()}"
    }

    static String garantirXCaracterOnNumber(long number, int x) {
        String formatedNumber = ""
        int numberOfCharacterToIncrise = 0

        formatedNumber = number.toString()

        numberOfCharacterToIncrise = x - formatedNumber.length()

        for (int i = 0; i < numberOfCharacterToIncrise; i++) {
            formatedNumber = "0" + formatedNumber
        }

        formatedNumber
    }

//    static StringEntity parseToJSON(Object object) throws JsonProcessingException {
//
//        Gson g = new Gson()
//        String restObject = g.toJson(object)
//        StringEntity inputAddPatient = new StringEntity(restObject, "UTF-8")
//        inputAddPatient.setContentType("application/json")
//
//        return inputAddPatient
//    }

    static String formatToYYYYMMDD(LocalDateTime date) {
        date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }

    static LocalDateTime dateformatToYYYYMMDD(String date) {
        LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }

    static String dateformatToDDMMMYYYY(LocalDateTime date) {
        date.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
    }

    static LocalDateTime addDaysInDate(LocalDateTime theDate, int days) {
        theDate.plusDays(days)
    }

    static boolean compareStringIgnoringAccents(String a, String b) {
        final Collator instance = Collator.getInstance()

        instance.setStrength(Collator.NO_DECOMPOSITION)

        instance.compare(a, b) == 0
    }

    static String stripAccents(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD)
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
        s
    }

    static String excludeProcessedProp(List<String> strings) {
        String newProps = null
        strings.each { s ->
            if (stringHasValue(newProps)) {
                newProps += ".$s"
            }
            newProps = s
        }

        newProps
    }

    List<String> splitString(String st, String separator) {
        if (!stringHasValue(st)) {
            return null
        }

        List<String> result = new ArrayList<>()
        String[] exploded = st.split(separator)

        for (int i = 0; i < exploded.length - 1; i++) {
            result.add(exploded[i])
        }
        result
    }

    static String getMd5(String input) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5")

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes())

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest)

            // Convert message digest into hex value
            String hashtext = no.toString(16)
            while (hashtext.length() < 32) {
                hashtext = "0$hashtext"
            }
            hashtext
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e)
        }
    }
}
