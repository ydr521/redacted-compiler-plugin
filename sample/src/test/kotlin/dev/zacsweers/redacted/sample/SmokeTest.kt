package dev.zacsweers.redacted.sample

import dev.zacsweers.redacted.annotations.Redacted
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SmokeTest {
  @Test
  fun userExample() {
    val user = User("Bob", "2815551234")
    assertThat(user.toString()).isEqualTo("User(name=Bob, phoneNumber=██)")
  }

  @Test
  fun classExample() {
    val sensitiveData = SensitiveData("123-456-7890", "1/1/00")
    assertThat(sensitiveData.toString()).isEqualTo("SensitiveData(██)")
  }

  @Redacted
  data class SensitiveData(val ssn: String, val birthday: String)

  @Test
  fun complex() {
    val complex = Complex(
        "redactedReferenceType",
        null,
        "referenceType",
        null,
        1,
        null,
        2,
        null,
        arrayOf("redactedArrayReferenceType"),
        null,
        arrayOf("arrayReferenceType"),
        null,
        intArrayOf(3),
        null,
        intArrayOf(4),
        null,
        listOf(5),
        null,
        listOf(6),
        null,
        7,
        null,
        8,
        null
    )

    assertThat(complex.toString()).isEqualTo("Complex(" +
        "redactedReferenceType=██, " +
        "redactedNullableReferenceType=██, " +
        "referenceType=referenceType, " +
        "nullableReferenceType=null, " +
        "redactedPrimitiveType=██, " +
        "redactedNullablePrimitiveType=██, " +
        "primitiveType=2, " +
        "nullablePrimitiveType=null, " +
        "redactedArrayReferenceType=██, " +
        "redactedNullableArrayReferenceType=██, " +
        "arrayReferenceType=[arrayReferenceType], " +
        "nullableArrayReferenceType=null, " +
        "redactedArrayPrimitiveType=██, " +
        "redactedNullableArrayPrimitiveType=██, " +
        "arrayPrimitiveType=[4], " +
        "nullableArrayGenericType=null, " +
        "redactedGenericCollectionType=██, " +
        "redactedNullableGenericCollectionType=██, " +
        "genericCollectionType=[6], " +
        "nullableGenericCollectionType=null, " +
        "redactedGenericType=██, " +
        "redactedNullableGenericType=██, " +
        "genericType=8, " +
        "nullableGenericType=null" +
        ")"
    )
  }

  data class Complex<T>(
      @Redacted val redactedReferenceType: String,
      @Redacted val redactedNullableReferenceType: String?,
      val referenceType: String,
      val nullableReferenceType: String?,
      @Redacted val redactedPrimitiveType: Int,
      @Redacted val redactedNullablePrimitiveType: Int?,
      val primitiveType: Int,
      val nullablePrimitiveType: Int?,
      @Redacted val redactedArrayReferenceType: Array<String>,
      @Redacted val redactedNullableArrayReferenceType: Array<String>?,
      val arrayReferenceType: Array<String>,
      val nullableArrayReferenceType: Array<String>?,
      @Redacted val redactedArrayPrimitiveType: IntArray,
      @Redacted val redactedNullableArrayPrimitiveType: IntArray?,
      val arrayPrimitiveType: IntArray,
      val nullableArrayGenericType: IntArray?,
      @Redacted val redactedGenericCollectionType: List<T>,
      @Redacted val redactedNullableGenericCollectionType: List<T>?,
      val genericCollectionType: List<T>,
      val nullableGenericCollectionType: List<T>?,
      @Redacted val redactedGenericType: T,
      @Redacted val redactedNullableGenericType: T?,
      val genericType: T,
      val nullableGenericType: T?
  )
}