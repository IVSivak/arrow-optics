package arrow.optics.instances

import arrow.core.Option
import arrow.core.ListK
import arrow.core.extensions.listk.eq.eq
import arrow.core.extensions.option.eq.eq
import arrow.optics.extensions.option.each.each
import arrow.core.test.UnitSpec
import arrow.core.test.generators.functionAToB
import arrow.core.test.generators.option
import arrow.optics.test.laws.TraversalLaws
import arrow.typeclasses.Eq
import io.kotest.property.Arb

class OptionInstanceTest : UnitSpec() {

  init {

    testLaws(TraversalLaws.laws(
      traversal = Option.each<String>().each(),
      aGen = Arb.option(Arb.string()),
      bGen = Arb.string(),
      funcGen = Arb.functionAToB(Arb.string()),
      EQA = Eq.any(),
      EQOptionB = Option.eq(Eq.any()),
      EQListB = ListK.eq(Eq.any())
    ))
  }
}
