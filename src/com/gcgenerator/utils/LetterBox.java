package com.gcgenerator.utils;

public class LetterBox {

	private double _xmin;
	private double _xmax;
	private double _ymin;
	private double _ymax;

	public LetterBox(double xmin, double xmax, double ymin, double ymax){
		this._xmin = xmin;
		this._xmax = xmax;
		this._ymin = xmin;
		this._ymax = xmax;
	}

	// getters and setters
	public double get_xmin() {
		return _xmin;
	}

	public void set_xmin(double _xmin) {
		this._xmin = _xmin;
	}

	public double get_xmax() {
		return _xmax;
	}

	public void set_xmax(double _xmax) {
		this._xmax = _xmax;
	}

	public double get_ymin() {
		return _ymin;
	}

	public void set_ymin(double _ymin) {
		this._ymin = _ymin;
	}

	public double get_ymax() {
		return _ymax;
	}

	public void set_ymax(double _ymax) {
		this._ymax = _ymax;
	}

	// shifters
	public void shift_x(double _x) {
		this._xmin += _x;
		this._xmax += _x;
	}

	public void shift_ymax(double _y) {
		this._ymin += _y;
		this._ymax += _y;
	}

	// size

	public double[] get_dimensions() {

		double[] dimension = {Math.abs(this._xmin) + Math.abs(this._xmax), Math.abs(this._ymin) + Math.abs(this._ymax)};
		return dimension;
	}

}
