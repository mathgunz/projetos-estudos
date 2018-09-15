package br.com.java.prova.v2;

public class ComplexNumber {

	private Float real;
	private Float imaginaria;

	public ComplexNumber() {
		this.real = 0f;
		this.imaginaria = 0f;
	}

	public ComplexNumber(Float real, Float imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
	}

	public void somarNumerosComplexos(ComplexNumber numeroComplexo) {
		ComplexNumber complexNumber = ComplexNumber.somarNumerosComplexos(this, numeroComplexo);
		this.real = complexNumber.real;
		this.imaginaria = complexNumber.imaginaria;
	}

	private static ComplexNumber somarNumerosComplexos(ComplexNumber z1, ComplexNumber z2) {

		Float reais = z1.real + z2.real;
		Float imaginaria = z1.imaginaria + z2.imaginaria;
		return new ComplexNumber(reais, imaginaria);
	}

	public static void main(String[] args) {

		ComplexNumber complexNumber = new ComplexNumber(3f, 2f);
		ComplexNumber complexNumber2 = new ComplexNumber(5f, -3f);
		
		complexNumber.somarNumerosComplexos(complexNumber2);
		
		System.out.println("Resultado:"+complexNumber.real +" "+ complexNumber.imaginaria+"i");
	}

	public Float getReal() {
		return real;
	}

	public void setReal(Float real) {
		this.real = real;
	}

	public Float getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(Float imaginaria) {
		this.imaginaria = imaginaria;
	}
}