<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8"
		indent="yes" />
	<xsl:template match="/">
		<xsl:element name="WorkOrder"><!--Defining Element -->
			<xsl:element name="Id">
				<xsl:value-of select="/DATA2SC/@ID" /><!-- Getting attribute 
					value of ID -->
			</xsl:element>
			<xsl:element name="Provider">
				<xsl:element name="Id">
					<xsl:value-of select="/DATA2SC/CALL/@PRO" /><!-- Getting 
						attribute value of Pro -->
				</xsl:element>
				<xsl:element name="Name">
					Service Channel               <!-- Giving HardCoded Value -->
				</xsl:element>
				<xsl:element name="SourceId">
					<xsl:value-of select="/DATA2SC/CALL/@TR_NUM" />
				</xsl:element>
				<xsl:element name="RequestedDate">
					<xsl:value-of select="/DATA2SC/CALL/@DATETIME" />
				</xsl:element>
				<xsl:element name="ActionDate" />
				<xsl:element name="SourceProperties">
					<xsl:element name="Properties">
						<xsl:attribute name="name">ProviderStatus</xsl:attribute>
						<xsl:value-of select="/DATA2SC/CALL/@STATUS" />
					</xsl:element>

					<xsl:element name="Properties">
						<xsl:attribute name="name">Trade</xsl:attribute>
						<xsl:value-of select="/DATA2SC/CALL/@TRADE" />
					</xsl:element>

					<xsl:element name="Properties">
						<xsl:attribute name="name">Category</xsl:attribute>
						<xsl:value-of select="/DATA2SC/CALL/@CATEGORY" />
					</xsl:element>
					<xsl:element name="Name" />

				</xsl:element>
			</xsl:element>

			<xsl:element name="Customer">
				<xsl:element name="Id">
					<xsl:value-of select="/DATA2SC/CALL/@SUB" />
				</xsl:element>
			</xsl:element>

			<xsl:element name="Address">
				<xsl:element name="Id">
					<xsl:value-of select="/DATA2SC/CALL/@LOC" />
				</xsl:element>
				<xsl:element name="Contacts">
					<xsl:element name="Contact">
						<xsl:element name="Name">
							<xsl:value-of select="/DATA2SC/CALL/@CALLER" />
						</xsl:element>
					</xsl:element>
				</xsl:element>
			</xsl:element>

			<xsl:element name="ScheduledDate">
				<xsl:value-of select="/DATA2SC/CALL/@SCHED_DATETIME" />
			</xsl:element>

			<xsl:element name="CreatedBy" />

			<xsl:element name="Description">
				<xsl:value-of select="/DATA2SC/CALL/PROBLEM" />
			</xsl:element>

			<xsl:element name="CustomerWorkOrder">
				<xsl:value-of select="/DATA2SC/CALL/@WO_NUM" />
			</xsl:element>

			<xsl:element name="CustomerPurchaseOrder">
				<xsl:value-of select="/DATA2SC/CALL/@PO_NUM" />
			</xsl:element>

			<xsl:element name="Priority">
				<xsl:value-of select="/DATA2SC/CALL/@PRIORITY" />
			</xsl:element>

			<xsl:element name="CallType">
				<xsl:value-of select="/DATA2SC/CALL/@TYPE" />
			</xsl:element>

			<xsl:element name="Notes">
				<xsl:element name="Note">
					<xsl:element name="Subject">
						<xsl:value-of select="/DATA2SC/CALL/@CALLER" />
					</xsl:element>
					<xsl:element name="NoteType">
						SC
					</xsl:element>
					<xsl:element name="NoteTypeId">
						1331133131
					</xsl:element>
				</xsl:element>
				<xsl:element name="Private">
					false
				</xsl:element>
			</xsl:element>

			<xsl:element name="CallSource">
				<xsl:element name="Id">
					Service Chanel
				</xsl:element>
				<xsl:element name="KVP" />
			</xsl:element>

			<xsl:element name="Constraints">
				<xsl:attribute name="name">Amount</xsl:attribute>
				<xsl:value-of select="/DATA2SC/CALL/@NTE" />
			</xsl:element>


		</xsl:element>
	</xsl:template>
</xsl:stylesheet>
