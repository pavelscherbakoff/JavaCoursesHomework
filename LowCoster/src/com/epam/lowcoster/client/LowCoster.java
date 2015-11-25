package com.epam.lowcoster.client;

import java.util.Date;
import java.util.List;
import com.epam.lowcoster.shared.Flight;
import com.epam.lowcoster.shared.OrderedTicket;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class LowCoster implements EntryPoint {

	private final LowCosterServiceAsync lowCosterService = GWT.create(LowCosterService.class);
	private String userName;
	private Integer userId;
	private DateBox dateBox;
	private ListBox fromDropDown, toDropDown;
	private CellTable<Flight> searchFlightsTable;
	private CellTable<OrderedTicket> myFlightsTable;

	public void onModuleLoad() {
		drawLoginForm();
	}

	private void drawLoginForm() {
		RootLayoutPanel.get().clear();

		final TextBox loginField = new TextBox();
		loginField.setWidth("200px");
		loginField.setHeight("20px");
		final PasswordTextBox passwordField = new PasswordTextBox();
		passwordField.setWidth("200px");
		passwordField.setHeight("20px");
		final Label errorLabel = new Label();
		errorLabel.setStyleName("serverResponseLabelError");
		final Button submitButton = new Button("Login");
		final Button registerButton = new Button("Registration");

		FlexTable layout = new FlexTable();
		layout.setCellSpacing(6);

		FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
		cellFormatter.setColSpan(0, 0, 2);
		cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

		layout.setHTML(1, 0, "Username");
		layout.setWidget(1, 1, loginField);
		layout.setHTML(2, 0, "Password");
		layout.setWidget(2, 1, passwordField);
		layout.setWidget(3, 0, submitButton);
		layout.setWidget(3, 1, errorLabel);
		layout.setWidget(4, 0, registerButton);

		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setStyleName("loginBox");
		decPanel.setWidget(layout);

		RootLayoutPanel.get().add(decPanel);

		loginField.setFocus(true);
		loginField.selectAll();

		submitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				errorLabel.setText("");

				lowCosterService.logIn(loginField.getText(), passwordField.getText(), new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						userName = loginField.getText();
						userId = result;
						drawUI();
					}

					@Override
					public void onFailure(Throwable caught) {
						loginField.setText("");
						passwordField.setText("");
						errorLabel.setText("Wrong user name or password");
						loginField.setFocus(true);
					}
				});
			}
		});

		registerButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				drawRegistrationForm();
			}
		});
	}

	private void drawRegistrationForm() {

		RootLayoutPanel.get().clear();

		final TextBox loginField = new TextBox();
		loginField.setWidth("200px");
		loginField.setHeight("20px");
		final TextBox firstNameField = new TextBox();
		firstNameField.setWidth("200px");
		firstNameField.setHeight("20px");
		final TextBox secondNameField = new TextBox();
		secondNameField.setWidth("200px");
		secondNameField.setHeight("20px");
		final ListBox sexDropdown = new ListBox();
		sexDropdown.addItem("Male");
		sexDropdown.addItem("Female");
		sexDropdown.setWidth("210px");
		sexDropdown.setHeight("32px");
		final TextBox passportField = new TextBox();
		passportField.setWidth("200px");
		passportField.setHeight("20px");
		final PasswordTextBox passwordField = new PasswordTextBox();
		passwordField.setWidth("200px");
		passwordField.setHeight("20px");

		final Label errorLabel = new Label();
		errorLabel.setStyleName("serverResponseLabelError");

		final Button submitButton = new Button("Register");

		FlexTable layout = new FlexTable();
		layout.setCellSpacing(6);

		FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
		cellFormatter.setColSpan(0, 0, 2);
		cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

		layout.setHTML(1, 0, "Username");
		layout.setWidget(1, 1, loginField);
		layout.setHTML(2, 0, "Password");
		layout.setWidget(2, 1, passwordField);
		layout.setHTML(3, 0, "First name");
		layout.setWidget(3, 1, firstNameField);
		layout.setHTML(4, 0, "Second name");
		layout.setWidget(4, 1, secondNameField);
		layout.setHTML(5, 0, "Sex");
		layout.setWidget(5, 1, sexDropdown);
		layout.setHTML(6, 0, "Passport");
		layout.setWidget(6, 1, passportField);
		layout.setWidget(7, 0, submitButton);
		layout.setWidget(8, 1, errorLabel);

		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setStyleName("loginBox");
		decPanel.setWidget(layout);

		RootLayoutPanel.get().add(decPanel);

		loginField.setFocus(true);
		loginField.selectAll();

		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String login = loginField.getText().isEmpty() ? null : loginField.getText();
				String password = passwordField.getText().isEmpty() ? null : passwordField.getText();
				String firstName = firstNameField.getText().isEmpty() ? null : firstNameField.getText();
				String secondName = secondNameField.getText().isEmpty() ? null : secondNameField.getText();
				String sex = sexDropdown.getSelectedValue().isEmpty() ? null : sexDropdown.getSelectedValue();
				String passport = passportField.getText().isEmpty() ? null : passportField.getText();

				lowCosterService.registerClient(login, password, firstName, secondName, sex, passport,
						new AsyncCallback<Integer>() {

					@Override
					public void onSuccess(Integer result) {
						final DialogBox dialogBox = new DialogBox();
						dialogBox.center();
						final Button confirmButton = new Button("OK");

						VerticalPanel dialogVPanel = new VerticalPanel();
						dialogVPanel.add(new HTML("You are registered"));
						dialogVPanel.add(confirmButton);
						dialogBox.setWidget(dialogVPanel);

						confirmButton.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								dialogBox.hide();
								drawLoginForm();
							}
						});
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}
				});
			}
		});
	}

	private void drawUI() {

		RootLayoutPanel.get().clear();
		TabLayoutPanel tabPanel = new TabLayoutPanel(2.5, Unit.EM);
		tabPanel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);

		SimplePanel buyTicketsTab = new SimplePanel();
		SimplePanel myTicketsTab = new SimplePanel();

		FlexTable searchFlightsLayout = new FlexTable();
		searchFlightsLayout.setCellSpacing(6);
		FlexCellFormatter cellFormatter = searchFlightsLayout.getFlexCellFormatter();

		cellFormatter.setColSpan(0, 0, 2);
		cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

		fromDropDown = new ListBox(false);
		fromDropDown.setWidth("200px");
		fromDropDown.setHeight("27px");
		lowCosterService.getDeparturesList(new AsyncCallback<List<String>>() {

			@Override
			public void onSuccess(List<String> result) {
				for (String item : result)
					fromDropDown.addItem(item);
				fromDropDown.setSelectedIndex(0);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});

		toDropDown = new ListBox(false);
		toDropDown.setWidth("200px");
		toDropDown.setHeight("27px");
		lowCosterService.getArrivalsList(new AsyncCallback<List<String>>() {

			@Override
			public void onSuccess(List<String> result) {
				for (String item : result)
					toDropDown.addItem(item);
				toDropDown.setSelectedIndex(0);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});

		dateBox = new DateBox();
		dateBox.setHeight("15px");
		dateBox.setWidth("190px");
		dateBox.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateBox.setValue(new Date());
		dateBox.getDatePicker().setYearArrowsVisible(true);

		final Button submitButton = new Button("Find flights");

		searchFlightsTable = new CellTable<>();
		searchFlightsTable.setWidth("100%", true);
		searchFlightsTable.setPageSize(20);

		addSearchFlightsTableColumns(searchFlightsTable);

		submitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				refreshFilghtsTable();
			}
		});

		final Button logoutButton = new Button("Logout");
		logoutButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.Location.reload();
			}
		});

		searchFlightsLayout.setHTML(0, 0, "Hello, " + userName + "!");
		searchFlightsLayout.setWidget(0, 3, logoutButton);
		searchFlightsLayout.setHTML(3, 0, "From");
		searchFlightsLayout.setWidget(3, 1, fromDropDown);
		searchFlightsLayout.setHTML(4, 0, "To");
		searchFlightsLayout.setWidget(4, 1, toDropDown);
		searchFlightsLayout.setHTML(5, 0, "Date");
		searchFlightsLayout.setWidget(5, 1, dateBox);
		searchFlightsLayout.setWidget(6, 1, submitButton);
		searchFlightsLayout.setWidget(7, 2, searchFlightsTable);

		cellFormatter.setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(6, 1, HasHorizontalAlignment.ALIGN_CENTER);

		DecoratorPanel searchFlightsDecPanel = new DecoratorPanel();
		searchFlightsDecPanel.setWidget(searchFlightsLayout);
		buyTicketsTab.setWidget(searchFlightsDecPanel);

		myFlightsTable = new CellTable<>();
		myFlightsTable.setWidth("100%", true);
		myFlightsTable.setPageSize(20);

		addMyFlightsTableColumns(myFlightsTable);

		myTicketsTab.setWidget(myFlightsTable);

		refreshMyFilghtsTable();

		tabPanel.add(buyTicketsTab, "Order tickets");
		tabPanel.add(myTicketsTab, "My tickets");

		RootLayoutPanel.get().add(tabPanel);
	}

	private void refreshFilghtsTable() {

		lowCosterService.searchFlights(fromDropDown.getSelectedValue(), toDropDown.getSelectedValue(),
				dateBox.getValue(), new AsyncCallback<List<Flight>>() {

					@Override
					public void onSuccess(List<Flight> flights) {
						searchFlightsTable.setRowCount(flights.size());
						searchFlightsTable.setRowData(0, flights);
					}

					@Override
					public void onFailure(Throwable caught) {
						searchFlightsTable.setRowCount(0);
						searchFlightsTable.setEmptyTableWidget(new Label("No Flights Found"));
					}
				});
	}

	private void addSearchFlightsTableColumns(final CellTable<Flight> table) {

		final TextColumn<Flight> flightNumberColumn = new TextColumn<Flight>() {
			@Override
			public String getValue(Flight object) {
				return object.getFlightNumber();
			}
		};
		table.addColumn(flightNumberColumn, "Flight Number");

		final TextColumn<Flight> departureColumn = new TextColumn<Flight>() {
			@Override
			public String getValue(Flight object) {
				return object.getDeparture();
			}
		};
		table.addColumn(departureColumn, "Departure");

		final TextColumn<Flight> departureTimeColumn = new TextColumn<Flight>() {
			@Override
			public String getValue(Flight object) {
				return object.getDepartureTime().toGMTString();
			}
		};
		table.addColumn(departureTimeColumn, "Departure Time");

		final TextColumn<Flight> arrivalColumn = new TextColumn<Flight>() {
			@Override
			public String getValue(Flight object) {
				return object.getArrival();
			}
		};
		table.addColumn(arrivalColumn, "Arrival");

		final TextColumn<Flight> arrivalTimeColumn = new TextColumn<Flight>() {
			@Override
			public String getValue(Flight object) {
				return object.getArrivalTime().toGMTString();
			}
		};
		table.addColumn(arrivalTimeColumn, "Arrival Time");

		final TextColumn<Flight> basePriceColumn = new TextColumn<Flight>() {
			@Override
			public String getValue(Flight object) {
				return String.valueOf(object.getBasePrice());
			}
		};
		table.addColumn(basePriceColumn, "Base Price");

		final TextColumn<Flight> seatsColumn = new TextColumn<Flight>() {
			@Override
			public String getValue(Flight object) {
				return String.valueOf(object.getSeats());
			}
		};
		table.addColumn(seatsColumn, "Seats");

		final TextColumn<Flight> freeSeatsColumn = new TextColumn<Flight>() {
			@Override
			public String getValue(Flight object) {
				return String.valueOf(object.getFreeSeats());
			}
		};
		table.addColumn(freeSeatsColumn, "Free Seats");

		final ButtonCell orderButton = new ButtonCell();
		Column<Flight, String> orderColumn = new Column<Flight, String>(orderButton) {
			public String getValue(Flight object) {
				return "Order";
			}
		};
		table.addColumn(orderColumn);

		orderColumn.setFieldUpdater(new FieldUpdater<Flight, String>() {
			@Override
			public void update(int index, final Flight object, String value) {
				orderFlight(object);
			}
		});
	}

	private void orderFlight(final Flight object) {
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Order a ticket for flight " + object.getFlightNumber());
		dialogBox.center();

		final Button confirmButton = new Button("Confirm");
		final Button cancelButton = new Button("Cancel");
		final CheckBox withBaggageCheckbox = new CheckBox("With baggage");
		final CheckBox businessClassCheckbox = new CheckBox("Business class");

		// изменить базовую стоимость билета в зависимости от

		// близости вылета (минус 1% за каждый день до вылета, но не более 50%)
		long daysBeforeDeparture = ((object.getDepartureTime().getTime() - new Date().getTime()) / (24 * 3600000)) + 1;
		if (daysBeforeDeparture > 50)
			daysBeforeDeparture = 50;

		// и наполненности рейса (добавляем стоимость, умноженную на процент
		// занятости рейса)
		double fullness = Double.valueOf(object.getFreeSeats()) / Double.valueOf(object.getSeats());

		final int correctedBasePrice = (int) (object.getBasePrice() * (2 - fullness)
				* (Double.valueOf(100 - daysBeforeDeparture) / 100));
		final HTML totalPriceLabel = new HTML(String.valueOf(correctedBasePrice));

		withBaggageCheckbox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				totalPriceLabel.setText(recalculateTotalPrice(correctedBasePrice, withBaggageCheckbox.isChecked(),
						businessClassCheckbox.isChecked()));

			}
		});

		businessClassCheckbox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				totalPriceLabel.setText(recalculateTotalPrice(correctedBasePrice, withBaggageCheckbox.isChecked(),
						businessClassCheckbox.isChecked()));
			}
		});

		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.add(withBaggageCheckbox);
		dialogVPanel.add(businessClassCheckbox);
		dialogVPanel.add(new HTML("<b>Total price:</b>"));
		dialogVPanel.add(totalPriceLabel);
		HorizontalPanel dialogHPanel = new HorizontalPanel();
		dialogHPanel.add(confirmButton);
		dialogHPanel.add(cancelButton);
		dialogVPanel.add(dialogHPanel);
		dialogVPanel.addStyleName("dialogVPanel");
		dialogBox.setWidget(dialogVPanel);

		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});

		confirmButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				lowCosterService.orderFlight(userId, object, withBaggageCheckbox.isChecked(),
						businessClassCheckbox.isChecked(), totalPriceLabel.getText(),
						new AsyncCallback<List<Flight>>() {

					@Override
					public void onSuccess(List<Flight> flights) {
						dialogBox.hide();
						refreshFilghtsTable();
						refreshMyFilghtsTable();
					}

					@Override
					public void onFailure(Throwable caught) {
						dialogBox.hide();
						Window.alert("Ordering is Failed");
					}
				});
			}
		});
	}

	private void addMyFlightsTableColumns(final CellTable<OrderedTicket> table) {

		final TextColumn<OrderedTicket> flightNumberColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return object.getFlightNumber();
			}
		};
		table.addColumn(flightNumberColumn, "Flight Number");

		final TextColumn<OrderedTicket> departureColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return object.getDeparture();
			}
		};
		table.addColumn(departureColumn, "Departure");

		final TextColumn<OrderedTicket> departureTimeColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return object.getDepartureTime().toGMTString();
			}
		};
		table.addColumn(departureTimeColumn, "Departure Time");

		final TextColumn<OrderedTicket> arrivalColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return object.getArrival();
			}
		};
		table.addColumn(arrivalColumn, "Arrival");

		final TextColumn<OrderedTicket> arrivalTimeColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return object.getArrivalTime().toGMTString();
			}
		};
		table.addColumn(arrivalTimeColumn, "Arrival Time");

		final TextColumn<OrderedTicket> withBaggageColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return String.valueOf(object.isBaggage());
			}
		};
		table.addColumn(withBaggageColumn, "With baggage");

		final TextColumn<OrderedTicket> businessClassColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return String.valueOf(object.isBusiness());
			}
		};
		table.addColumn(businessClassColumn, "Business class");

		final TextColumn<OrderedTicket> priceColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return String.valueOf(object.getPrice());
			}
		};
		table.addColumn(priceColumn, "Price");

		final TextColumn<OrderedTicket> isPaidColumn = new TextColumn<OrderedTicket>() {
			@Override
			public String getValue(OrderedTicket object) {
				return String.valueOf(object.isPaid());
			}
		};
		table.addColumn(isPaidColumn, "Paid");

		final ButtonCell orderButton = new ButtonCell();
		Column<OrderedTicket, String> payColumn = new Column<OrderedTicket, String>(orderButton) {
			public String getValue(OrderedTicket object) {
				return "Pay ticket";
			}
		};

		table.addColumn(payColumn);

		payColumn.setFieldUpdater(new FieldUpdater<OrderedTicket, String>() {
			@Override
			public void update(int index, final OrderedTicket object, String value) {
				payTicket(object.getTicketId(), object.isPaid());
			}
		});

		final ButtonCell cancelButton = new ButtonCell();
		Column<OrderedTicket, String> cancelColumn = new Column<OrderedTicket, String>(cancelButton) {
			public String getValue(OrderedTicket object) {
				return "Cancel";
			}
		};

		table.addColumn(cancelColumn);

		cancelColumn.setFieldUpdater(new FieldUpdater<OrderedTicket, String>() {

			@Override
			public void update(int index, OrderedTicket object, String value) {
				cancelOrder(object.getTicketId(), object.getFlightId());
			}
		});
	}

	private void cancelOrder(int ticketId, int flightId) {
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Order is cancelled");
		dialogBox.center();
		final VerticalPanel dialogVPanel = new VerticalPanel();

		lowCosterService.cancelOrder(ticketId, flightId, new AsyncCallback<Integer>() {

			@Override
			public void onSuccess(Integer result) {
				refreshFilghtsTable();
				refreshMyFilghtsTable();
				dialogVPanel.add(new HTML("Order is cancelled!"));
			}

			@Override
			public void onFailure(Throwable caught) {
				dialogVPanel.add(new HTML("Order is not cancelled. Something is wrong!"));
			}
		});
		final Button closeButton = new Button("Close");
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});
	}

	private void payTicket(int ticketId, boolean isPaid) {

		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Payment status");
		dialogBox.center();
		final VerticalPanel dialogVPanel = new VerticalPanel();

		if (isPaid)
			dialogVPanel.add(new HTML("Ticket is already paid!"));
		else
			lowCosterService.payTicket(ticketId, new AsyncCallback<Integer>() {

				@Override
				public void onSuccess(Integer result) {
					refreshMyFilghtsTable();
					dialogVPanel.add(new HTML("Ticket is paid. Thank you!"));
				}

				@Override
				public void onFailure(Throwable caught) {
					dialogVPanel.add(new HTML("Ticket is not paid. Something is wrong!"));
				}
			});
		final Button closeButton = new Button("Close");
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});
	}

	private void refreshMyFilghtsTable() {

		lowCosterService.searchMyFlights(userId, new AsyncCallback<List<OrderedTicket>>() {

			@Override
			public void onSuccess(List<OrderedTicket> myFlights) {
				myFlightsTable.setRowCount(myFlights.size());
				myFlightsTable.setRowData(0, myFlights);
			}

			@Override
			public void onFailure(Throwable caught) {
				myFlightsTable.setRowCount(0);
				myFlightsTable.setEmptyTableWidget(new Label("No Tickets Ordered"));
			}
		});
	}

	private String recalculateTotalPrice(int basePrice, boolean withBaggage, boolean businessClass) {
		if (withBaggage)
			basePrice *= 2.0;
		if (businessClass)
			basePrice *= 1.5;
		return String.valueOf(basePrice);
	}
}
