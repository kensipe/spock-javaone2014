package com.math

import spock.lang.FailsWith
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import static spock.util.matcher.HamcrestMatchers.closeTo
import static spock.util.matcher.HamcrestSupport.that

// hamcrest requires, runtime of core, plus the matchers, plus that or expect
/**
 *
 * @author ksipe
 */
class SimpleInterestCalculatorDataSpec extends Specification {

    @Unroll
      def "showing off vars list from custom data provider calc"() {
          given:
          def calc = new SimpleInterestCalculator(rate: 0.05)

          expect:
          interest == calc.calculate(amt, year)

          where:
          [year, interest, amt] << new SimpleInterestCalcDataProvider()
      }
}
